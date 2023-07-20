package com.example.Banking.Models;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name = "history")
//@NamedNativeQuery(name = "history",
//        query = "select his.account as account, his.amount as amount, his.action as action, his.date as date from history his where account=:accno",
//        resultSetMapping = "Mapping.viewhistory")
//@SqlResultSetMapping(
//        name="Mapping.viewhistory",
//        classes={
//                @ConstructorResult(
//                        targetClass=com.example.Banking.Models.History.class,
//                        columns={
//                                @ColumnResult(name="account"),
//                                @ColumnResult(name="amount"),
//                                @ColumnResult(name="action"),
//                                @ColumnResult(name="date")
//                        })})
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private long account;
    private int amount;
    private String action;
    private LocalDate date;

    public History(Integer id, long account, int amount, String action, LocalDate date) {
        super();
        this.id = id;
        this.account = account;
        this.amount = amount;
        this.action = action;
        this.date = date;
    }

    public History() {
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }



    public long getAccount() {
        return account;
    }

    public void setAccount(long account) {
        this.account = account;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }


}
