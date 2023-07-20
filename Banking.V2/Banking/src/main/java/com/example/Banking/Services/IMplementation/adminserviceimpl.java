package com.example.Banking.Services.IMplementation;


import com.example.Banking.Models.CustomerDetails;
import com.example.Banking.Models.viewtoadmin;
import com.example.Banking.Repositrories.CustomerRepo;
import com.example.Banking.Repositrories.viewrepo;
import com.example.Banking.Services.adminservice;
import com.example.Banking.Models.Accountdetails;
import com.example.Banking.Repositrories.Accountrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.apache.el.lang.ELArithmetic.isNumber;

@Service
public class adminserviceimpl implements adminservice {
    @Autowired
    CustomerRepo crepo;
    @Autowired
    Accountrepo arepo;
    @Autowired
    viewrepo  vrepo;

    @Override
    public List<viewtoadmin> getAllUsers() {
        return vrepo.getAllUser();
    }


    @Override
    public void enableaccount(String username) {
        crepo.enableaccount(username);

    }

    @Override
    public void disableaccount(String username) {
        crepo.disableaccount(username);

    }

    @Override
    public void activateaccount(String username) {
        crepo.activateaccount(username);
        CustomerDetails newcustomer = crepo.findbyusername(username);
        Accountdetails acc= new Accountdetails();
        Integer customerid =newcustomer.getId();
        acc.setAccno(Long.parseLong("34578921"+String.valueOf(customerid)));
        acc.setUsername(username);
        arepo.save(acc);
    }

    @Override
    public void deleteaccount(String username) {
        crepo.deleteaccount(username);

    }
    @Override
    public List<CustomerDetails> getdeactivecustomers() {
        return crepo.finddeactiveaccounts();
    }

    @Override
    public viewtoadmin getbyusername(String username) {
        return vrepo.getcustomerbyusername(username);
    }


}
