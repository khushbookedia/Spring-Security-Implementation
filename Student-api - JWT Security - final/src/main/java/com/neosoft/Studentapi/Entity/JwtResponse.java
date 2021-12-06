package com.neosoft.Studentapi.Entity;

import java.io.Serializable;


public class JwtResponse implements Serializable {

    private static final long serialVersionUID = -698654564515454544L;



    private final String jwtToken;

    public JwtResponse(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public String getJwtToken() {
        return this.jwtToken;
    }



}
