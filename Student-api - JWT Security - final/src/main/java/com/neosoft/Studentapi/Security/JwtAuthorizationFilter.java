package com.neosoft.Studentapi.Security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.neosoft.Studentapi.Service.JwtUserDetailsService;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import static com.neosoft.Studentapi.Constants.SecurityConstants.*;

@Component
public class JwtAuthorizationFilter extends OncePerRequestFilter {

    //public JwtAuthorizationFilter(AuthenticationManager authenticationManager) {
//        super(authenticationManager);
//    }

    @Autowired
    private JwtUserDetailsService jwtUserDetailsService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws IOException, ServletException {

        String header = request.getHeader(HEADER_STRING);

        String username = null;
        String jwtToken = null;

        if(header == null || !header.startsWith(TOKEN_PREFIX)){
            chain.doFilter(request,response);
            return;
        }

        jwtToken= header.substring(7);
        System.out.println("Token: " + jwtToken);

        try{
            username = jwtTokenUtil.getUsernameFromToken(jwtToken);
        }
        catch (IllegalArgumentException e){
            System.out.println("Unable to get JWT Token");
        }
        catch (ExpiredJwtException e){
            System.out.println("JWT Token has expired");
        }


        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            UserDetails userDetails = this.jwtUserDetailsService.loadUserByUsername(username);

            if (jwtTokenUtil.validateToken(jwtToken, userDetails)) {

                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                usernamePasswordAuthenticationToken
                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            } else {
                System.out.println("Token is not validated");
            }
        }
        chain.doFilter(request, response);



//        if(username != null){
//            UserDetails userDetails = this.jwtUserDetailsService.loadUserByUsername(username);
//            UsernamePasswordAuthenticationToken authentication = getAuthentication(request, jwtToken, userDetails);
//
//            SecurityContextHolder.getContext().setAuthentication(authentication);
//            chain.doFilter(request,response);
//        }




    }

//    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request, String jwtToken, UserDetails userDetails) {
//
//        String token = request.getHeader(HEADER_STRING);
//
//        if(token != null){
//
//
//            String user = JWT.require(Algorithm.HMAC512(SECRET.getBytes()))
//                            .build()
//                            .verify(token.replace(TOKEN_PREFIX, ""))
//                            .getSubject();
//
//            if(user != null){
//                return new UsernamePasswordAuthenticationToken(user, null, userDetails.getAuthorities());
//            }
//
//            return null;
//        }
//
//        return null;
//    }
}
