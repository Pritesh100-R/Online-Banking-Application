package com.example.Banking.Services;


import com.example.Banking.Models.CustomerDetails;
import com.example.Banking.Models.viewtoadmin;

import java.util.List;

public interface adminservice {
    public List<viewtoadmin> getAllUsers();
    //public List<Transfer> getAllTransactions(long accountNo);
    //public List<ChequebookRequest> getAllChequebookRequests();
    //public void acceptChequebookRequest(int accNo);
    public void enableaccount(String username);
    public void disableaccount(String username);
    public void activateaccount(String username);
    public void deleteaccount(String username);
    public List<CustomerDetails> getdeactivecustomers();
    //public void setUserFeatures(String username, int featureId);
    //public UserDisplay searchUser(String userDetail);
    //void acceptChequebookRequest(long accNo);
    public viewtoadmin getbyusername(String username);
    //public viewtoadmin searchUser(String userDetail);
}