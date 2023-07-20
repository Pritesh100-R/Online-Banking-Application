package com.example.Banking.Models;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table (name="transfer")
//@NamedNativeQuery(name = "saccount",
//        query = "select s.saccount as saccount, s.raccount as raccount, s.amount as amount, s.date as date from transfer s where saccount=:saccount",
//        resultSetMapping = "Mapping.saccount")
//@SqlResultSetMapping(
//        name="Mapping.saccount",
//        classes={
//                @ConstructorResult(
//                        targetClass=com.example.Banking.Models.Accountdetails.class,
//                        columns={
//                                @ColumnResult(name="accno"),
//                                @ColumnResult(name="balance"),
//                                @ColumnResult(name="username")
//                        })})
//@NamedNativeQuery(name = "raccount",
//        query = "select r.saccount as saccount, r.raccount as raccount, r.amount as amount, r.date as date from transfer s where raccount=:raccount",
//        resultSetMapping = "Mapping.raccount")
//@SqlResultSetMapping(
//        name="Mapping.raccount",
//        classes={
//                @ConstructorResult(
//                        targetClass=com.example.Banking.Models.Accountdetails.class,
//                        columns={
//                                @ColumnResult(name="accno"),
//                                @ColumnResult(name="balance"),
//                                @ColumnResult(name="username")
//                        })})
public class Transfer implements Comparable<Transfer>{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private long saccount;
    private long raccount;

    public Transfer(Integer id, long saccount, long raccount, int amount, LocalDate date) {
        this.id = id;
        this.saccount = saccount;
        this.raccount = raccount;
        this.amount = amount;
        this.date = date;
    }

    public Transfer() {
    }

    private int amount;
    private LocalDate date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public long getSaccount() {
        return saccount;
    }

    public void setSaccount(long saccount) {
        this.saccount = saccount;
    }

    public long getRaccount() {
        return raccount;
    }

    public void setRaccount(long raccount) {
        this.raccount = raccount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }



    @Override
    public int compareTo(Transfer o) {
        Integer i1=this.id;
        Integer i2=o.id;
        return i2.compareTo(i1);
    }
}