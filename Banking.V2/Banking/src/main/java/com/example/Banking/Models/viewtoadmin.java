package com.example.Banking.Models;

public class viewtoadmin {
    private String firstname;
    private String lastname;
    private long phone;
    private String email;
    private String username;
    private boolean accountstatus;
    private long accountno;
    private int Balance;

    public viewtoadmin() {
    }

    public viewtoadmin(String fname, String lname, long phone, String email, String username, boolean accountstatus, long accountno, int balance) {
        super();
        this.firstname = fname;
        this.lastname = lname;
        this.phone = phone;
        this.email = email;
        this.username = username;
        this.accountstatus = accountstatus;
        this.accountno = accountno;
        this.Balance = balance;
    }

    public String getFname() {
        return firstname;
    }

    public void setFname(String fname) {
        this.firstname = fname;
    }

    public String getLname() {
        return lastname;
    }

    public void setLname(String lname) {
        this.lastname = lname;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isAccountstatus() {
        return accountstatus;
    }

    public void setAccountstatus(boolean accountstatus) {
        this.accountstatus = accountstatus;
    }

    public long getAccountno() {
        return accountno;
    }

    public void setAccountno(long accountno) {
        this.accountno = accountno;
    }

    public int getBalance() {
        return Balance;
    }

    public void setBalance(int balance) {
        Balance = balance;
    }


}
