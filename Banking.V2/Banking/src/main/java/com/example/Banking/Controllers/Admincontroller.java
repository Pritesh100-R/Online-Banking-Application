package com.example.Banking.Controllers;

import com.example.Banking.Models.CustomerDetails;
import com.example.Banking.Models.viewtoadmin;
import com.example.Banking.Services.adminservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/bank")
public class Admincontroller {
    @Autowired
    adminservice aservice;
    @GetMapping("customer/{username}/activate")
    public void activateacc(@PathVariable("username") String username) {
        try {
            aservice.activateaccount(username);
        } catch (Exception e) {
            System.out.println("wrong username");
        }
    }
    @GetMapping("customer/{username}/activate/cancel")
    public void  cancelacc(@PathVariable("username") String username) {
        aservice.deleteaccount(username);
    }
    @GetMapping("customer/deactiveaccouts/all")
    public List<CustomerDetails> getdeactiveaccounts()
    {
        return aservice.getdeactivecustomers();
    }
    @GetMapping("customer/{username}/enable")
    public void enableUser(@PathVariable("username") String username)
    {
        aservice.enableaccount(username);
    }

    @GetMapping("customer/{username}/disable")
    public void disableUser(@PathVariable("username") String username)
    {
        aservice.disableaccount(username);
    }
    @GetMapping("customer/all")
    public List<viewtoadmin> getAllUsers()
    {
        return aservice.getAllUsers();
    }
    @GetMapping("customer/search/{username}")
    public viewtoadmin getbyusername(@PathVariable("username") String username){
        return aservice.getbyusername(username);
    }
}