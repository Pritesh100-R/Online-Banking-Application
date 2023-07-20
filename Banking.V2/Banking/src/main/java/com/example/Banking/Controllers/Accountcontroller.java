package com.example.Banking.Controllers;

import com.example.Banking.Models.*;
import com.example.Banking.Repositrories.Accountrepo;
import com.example.Banking.Repositrories.CustomerRepo;
import com.example.Banking.Services.Accountserives;
import com.example.Banking.Services.CustomerDetailService;
import com.example.Banking.Services.historyservice;
import com.example.Banking.Services.transferservice;
import com.example.Banking.actions.Depositresponse;
import com.example.Banking.actions.Transferresponse;
import com.example.Banking.actions.Withdrawreponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/bank")
public class Accountcontroller {
    @Autowired
    Accountserives aservice;
    @Autowired
    Accountrepo arepo;
    @Autowired
    historyservice hservice;
    @Autowired
    transferservice tservice;
    @GetMapping("/customer/account/{username}/viewbalance")
    public viewtocustomer viewbalance(@PathVariable("username") String username){
        return aservice.displaycustomer(username);
    }

    @GetMapping("customer/account/details/{username}")
    public Accountdetails getcustomer(@PathVariable("username") String username){
        return aservice.getcustomer(username);
    }
    @PostMapping("customer/account/deposit")
    public Depositresponse deposit(@RequestBody TransactionDetails details) {
        return aservice.deposit(details.getAccount(), details.getAmount());

    }

    @PostMapping("customer/account/withdraw")
    public Withdrawreponse withdraw(@RequestBody TransactionDetails details) {
        return aservice.withdraw(details.getAccount(), details.getAmount());
    }

    @PostMapping("customer/account/transfer")
    public Transferresponse transfer(@RequestBody TransferDetails details) {
        Accountdetails p=arepo.findByUsername(details.getUsername());
        //Saccount s=sdao.findByUsername(details.getUsername());
        return aservice.transfer(details.getSaccount(), details.getRaccount(), details.getAmount());
//        if(p.getAccno()==details.getSaccount()) {
//                    //String len = Integer.toString(details.getSaccount());
//            return aservice.transfer(details.getSaccount(), details.getRaccount(), details.getAmount());
//        }
//        else {
//            Transferresponse response=new Transferresponse();
//            response.setSaccount(details.getSaccount());
//            response.setResponseMessage("Dear user You can only transfer funds from the accounts registed with you");
//            response.setTransferStatus(false);
//            return response;
//        }
    }
    @GetMapping("customer/account/getHistory/{account}")
    public List<History> getHistory(@PathVariable("account") long account )
    {
        return hservice.getHistory(account);
    }

    @GetMapping("customer/account/getTransfers/{account}")
    public List<Transfer> getTransfers(@PathVariable("account") long account )
    {
        return tservice.getTransfers(account);
    }


}
