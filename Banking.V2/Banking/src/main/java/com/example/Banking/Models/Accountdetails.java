package com.example.Banking.Models;

import com.example.Banking.Models.CustomerDetails;
import jakarta.persistence.*;

@Entity
@Table(name="account")

@NamedNativeQuery(name = "findbyusername",
        query = "select acc.accno as accno, acc.balance as balance, acc.username as username from account acc where username=:username",
        resultSetMapping = "Mapping.findbyusername")
@SqlResultSetMapping(
        name="Mapping.findbyusername",
        classes={
                @ConstructorResult(
                        targetClass=com.example.Banking.Models.Accountdetails.class,
                        columns={
                                @ColumnResult(name="accno"),
                                @ColumnResult(name="balance"),
                                @ColumnResult(name="username")
                        })})
@NamedNativeQuery(name = "findbyaccno",
        query = "select acc.accno as accno, acc.balance as balance, acc.username as username from account acc where accno=:accno",
        resultSetMapping = "Mapping.findbyaccno")
@SqlResultSetMapping(
        name="Mapping.findbyaccno",
        classes={
                @ConstructorResult(
                        targetClass=com.example.Banking.Models.Accountdetails.class,
                        columns={
                                @ColumnResult(name="accno"),
                                @ColumnResult(name="balance"),
                                @ColumnResult(name="username"),
                                //@ColumnResult(name="customer")
                        })})
public class Accountdetails {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    private long accno;

    private int balance;

    private String username;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private CustomerDetails customer;


    public Accountdetails(Integer id, long accno, int balance, String username) {
        this.id = id;
        this.accno = accno;
        this.balance = balance;
        this.username = username;
        //this.customer=customer;
    }

    public Accountdetails() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public long getAccno() {
        return accno;
    }

    public void setAccno(long accno) {
        this.accno = accno;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public CustomerDetails getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDetails customer) {
        this.customer = customer;
    }

}

