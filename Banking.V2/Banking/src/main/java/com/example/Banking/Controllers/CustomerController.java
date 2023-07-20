package com.example.Banking.Controllers;


import com.example.Banking.Models.CustomerDetails;
import com.example.Banking.Models.UpdateDetails;
import com.example.Banking.Models.viewtocustomer;
import com.example.Banking.actions.CustomerDetailsResponse;
import com.example.Banking.Services.CustomerDetailService;
import com.example.Banking.actions.UpdatepasswordResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/bank")
public class CustomerController {
    @Autowired
    CustomerDetailService service;
    @PostMapping("/newaccount")
    public CustomerDetailsResponse Register(@RequestBody CustomerDetails customer){
        return service.CreateAcc(customer);

    }
    @GetMapping("/show")
    public List<CustomerDetails> display(){
        return service.show();
    }

    @PostMapping("/update/profile")
    public UpdatepasswordResponse updatepass(@RequestBody UpdateDetails update){
        return service.updatepass(update);
    }

}
