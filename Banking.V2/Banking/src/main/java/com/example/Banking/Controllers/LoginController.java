package com.example.Banking.Controllers;

import com.example.Banking.Models.LoginDetails;
import com.example.Banking.Services.LoginDetailsService;
import com.example.Banking.actions.LoginDetailsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/bank")
public class LoginController {
    @Autowired
    LoginDetailsService service;
//    @PostMapping(/login)
//    public LoginDetailsResponse createlogin(LoginDetails log){
//        return service.CustomerLogin(log);
//    }
    @PostMapping("/login")
    public LoginDetailsResponse createlogin(@RequestBody  LoginDetails log){
        return service.CustomerLogin(log);
    }

}
