package com.example.Banking.Services.IMplementation;

import com.example.Banking.Models.CustomerDetails;
import com.example.Banking.Models.LoginDetails;
import com.example.Banking.Repositrories.CustomerRepo;
import com.example.Banking.Services.LoginDetailsService;
import com.example.Banking.actions.LoginDetailsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginDetailImpl implements LoginDetailsService {
    @Autowired
    CustomerRepo repo;

    public LoginDetailsResponse CustomerLogin(LoginDetails log) {
        LoginDetailsResponse response =new LoginDetailsResponse();
        Boolean flag=true;
        response.setTemp(flag);
        CustomerDetails customer=null;
        response.setMessage("Successfull login");
        try{
            customer = repo.findbyusername(log.getUsername());
            response.setUsername(customer.getUsername());
            if (!customer.isActivestatus()){
                flag=false;
                response.setMessage("Your account hasn't been approved yet");
            }
            else if (customer.isAccountstatus()){
                flag=false;
                response.setMessage("Your account has been disabled by admin");
            }
            else if (!log.getPassword().equals(customer.getPassword())){
                flag=false;
                response.setMessage("incorrect password");
            }
        }
        catch(Exception e){
            flag=false;
            response.setMessage("Your username or password is incorrect");
        }
        //response.setUsername(customer.getUsername());
        response.setTemp(flag);
        return response;

    }
}
