package com.example.Banking.Services.IMplementation;

import com.example.Banking.Models.Accountdetails;
import com.example.Banking.Models.CustomerDetails;
import com.example.Banking.Models.viewtocustomer;
import com.example.Banking.Repositrories.Accountrepo;
import com.example.Banking.Repositrories.CustomerRepo;
import com.example.Banking.Repositrories.Historyrepo;
import com.example.Banking.Repositrories.viewrepo;
import com.example.Banking.Services.Accountserives;
import com.example.Banking.Services.historyservice;
import com.example.Banking.Services.transferservice;
import com.example.Banking.actions.Depositresponse;
import com.example.Banking.actions.Transferresponse;
import com.example.Banking.actions.Withdrawreponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class accountserviceimpl implements Accountserives {
    @Autowired
    viewrepo vrepo;
    @Autowired
    CustomerRepo crepo;
    @Autowired
    Accountrepo arepo;
    @Autowired
    Historyrepo hrepo;
    @Autowired
    historyservice hservice;
    @Autowired
    transferservice tservice;

    @Override
    public viewtocustomer displaycustomer(String username) {
        return vrepo.getdetails(username);
    }

    @Override
    public Depositresponse deposit(long acc, int amount) {
        Depositresponse response = new Depositresponse();

        boolean flag = true;
        try {
            Accountdetails account = arepo.findByAccno(acc);
            account.setBalance(account.getBalance() + amount);
            hservice.addAction(acc, amount, account.getBalance(), "credit");
            arepo.updatebalance(account.getBalance(), account.getAccno());
            //arepo.save(account);
            response.setResponseMessage("Rs." + amount + " successfully deposited into your account balance is now Rs." + account.getBalance());
            response.setDepositStatus(flag);
        } catch (Exception e) {
            flag = false;
            response.setResponseMessage("Account number is incorrect");
            response.setDepositStatus(flag);
        }
        response.setAccount(acc);
        return response;
    }

    @Override
    public Withdrawreponse withdraw(long acc, int amount) {
        Withdrawreponse response = new Withdrawreponse();
        boolean flag = true;
        //try {
            Accountdetails account = arepo.findByAccno(acc);
            if (account != null){
            //CustomerDetails customer = crepo.findbyusername(account.getUsername());
            if (account.getBalance() >= amount) {
                account.setBalance(account.getBalance() - amount);
                hservice.addAction(acc, amount, account.getBalance(), "debit");
                arepo.updatebalance(account.getBalance(), account.getAccno());
                //arepo.save(account);
                response.setResponseMessage("Rs." + amount + " successfully withdrawn your account balance is now Rs." + account.getBalance());
                response.setWithdrawStatus(flag);
            } else {
                flag = false;
                response.setResponseMessage("Insufficient funds to complete the transaction");
                response.setWithdrawStatus(flag);
            }
        } else{
            flag = false;
            response.setResponseMessage("Account number is incorrect");
            response.setWithdrawStatus(flag);
        }

        response.setAccount(acc);
        return response;
    }

    @Override
    public Transferresponse transfer(long saccount, long raccount, int amount) {
        Transferresponse response = new Transferresponse();
        boolean flag = true;
        try {
            Accountdetails senderAccount = arepo.findByAccno(saccount);
            //String check = Long.toString(raccount);

            Accountdetails receiverAccount = arepo.findByAccno(raccount);
            if (senderAccount.getAccno() != receiverAccount.getAccno()) {
                if (senderAccount.getBalance() > amount) {
                    CustomerDetails customer = crepo.findbyusername(senderAccount.getUsername());
                    senderAccount.setBalance(senderAccount.getBalance() - amount);
                    receiverAccount.setBalance(receiverAccount.getBalance() + amount);
                    tservice.addAction(saccount, raccount, amount);
                    arepo.updatebalance(senderAccount.getBalance(), senderAccount.getAccno());
                    arepo.updatebalance(receiverAccount.getBalance(), receiverAccount.getAccno());
                    //arepo.save(senderAccount);
                    //arepo.save(receiverAccount);
                    response.setResponseMessage("Rs." + amount + " successfully transferred to account " + receiverAccount.getAccno());
                    response.setTransferStatus(flag);
                } else {
                    flag = false;
                    response.setResponseMessage("Insufficient funds to complete the transfer");
                    response.setTransferStatus(flag);
                }
            } else {
                flag = false;
                response.setResponseMessage("sender and recieiver accounts are same");
                response.setTransferStatus(flag);
            }
        } catch (Exception e) {
            flag = false;
            response.setResponseMessage("Account number is incorrect");
            response.setTransferStatus(flag);
        }
        response.setSaccount(saccount);
        return response;
    }

    @Override
    public Accountdetails getcustomer(String username) {
        return arepo.findByUsername(username);

    }
}
