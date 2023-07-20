package com.example.Banking.actions;

public class LoginDetailsResponse {
    private Boolean temp;
    private String message;
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }



    public Boolean getTemp() {
        return temp;
    }

    public void setTemp(Boolean temp) {
        this.temp = temp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
