package com.neosoft.Studentapi.Entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class JwtRequest implements Serializable {

    private static final long serialVersionUID = 4465781231235468784L;
    private String username;
    private String password;

    public JwtRequest(){

    }

    public JwtRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }


}
