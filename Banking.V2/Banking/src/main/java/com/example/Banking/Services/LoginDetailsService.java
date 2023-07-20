package com.example.Banking.Services;

import com.example.Banking.Models.LoginDetails;
import com.example.Banking.actions.LoginDetailsResponse;

public interface LoginDetailsService {
    public LoginDetailsResponse CustomerLogin(LoginDetails log);

}
