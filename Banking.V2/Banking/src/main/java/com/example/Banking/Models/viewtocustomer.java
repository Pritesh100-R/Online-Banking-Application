package com.example.Banking.Models;

public class viewtocustomer {
    String username;
    private long accnono;
    private int Balance;

    public viewtocustomer() {
    }

    public viewtocustomer(String username, long accnono, int balance) {
        this.username = username;
        this.accnono = accnono;
        Balance = balance;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getAccnono() {
        return accnono;
    }

    public void setAccnono(long accnono) {
        this.accnono = accnono;
    }

    public int getBalance() {
        return Balance;
    }

    public void setBalance(int balance) {
        Balance = balance;
    }
}
