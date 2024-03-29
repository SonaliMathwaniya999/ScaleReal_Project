package com.scalereal.model.admin;

public class AdminSignInResponse {
    private String status;
    private String token;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public AdminSignInResponse(String status, String token) {
        this.status = status;
        this.token = token;
    }
}
