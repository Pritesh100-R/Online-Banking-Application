package com.example.Banking.Services;

import com.example.Banking.Models.Accountdetails;
import com.example.Banking.Models.viewtocustomer;
import com.example.Banking.actions.Depositresponse;
import com.example.Banking.actions.Transferresponse;
import com.example.Banking.actions.Withdrawreponse;

public interface Accountserives {
    public viewtocustomer displaycustomer(String username);
    public Depositresponse deposit(long acc, int amount);
    public Withdrawreponse withdraw(long acc, int amount);
    public Transferresponse transfer(long saccount, long raccount, int amount);
    public Accountdetails getcustomer(String username);
}
