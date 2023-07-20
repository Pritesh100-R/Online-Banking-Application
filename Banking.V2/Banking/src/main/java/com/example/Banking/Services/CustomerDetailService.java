package com.example.Banking.Services;

import com.example.Banking.Models.CustomerDetails;
import com.example.Banking.Models.UpdateDetails;
import com.example.Banking.Models.viewtocustomer;
import com.example.Banking.actions.CustomerDetailsResponse;
import com.example.Banking.Repositrories.CustomerRepo;
import com.example.Banking.actions.UpdatepasswordResponse;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CustomerDetailService {
    public CustomerDetailsResponse CreateAcc(CustomerDetails customer);
    public List<CustomerDetails> show();
    public UpdatepasswordResponse updatepass(UpdateDetails pass);


}
