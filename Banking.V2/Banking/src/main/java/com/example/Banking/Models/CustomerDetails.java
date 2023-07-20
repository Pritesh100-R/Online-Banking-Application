package com.example.Banking.Models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mysql.cj.protocol.ColumnDefinition;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.ColumnDefault;

import java.sql.Date;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "customerdetails")
@NamedNativeQuery(name = "getAllUser",
        query = "select cust.firstname as fname, cust.lastname as lname, cust.phone as phone, cust.email as email, cust.username as username, cust.activestatus as accountstatus, acc.accno as accountno, acc.balance as Balance from customerdetails cust, account acc where cust.username=acc.username",
        resultSetMapping = "Mapping.viewresult")
@SqlResultSetMapping(
        name="Mapping.viewresult",
        classes={
                @ConstructorResult(
                        targetClass=com.example.Banking.Models.viewtoadmin.class,
                        columns={
                                @ColumnResult(name="fname"),
                                @ColumnResult(name="lname"),
                                @ColumnResult(name="phone"),
                                @ColumnResult(name="email"),
                                @ColumnResult(name="username"),
                                @ColumnResult(name="accountstatus"),
                                @ColumnResult(name="accountno"),
                                @ColumnResult(name="Balance")
                        })})
@NamedNativeQuery(name = "getcustomerbyusername",
        query = "select cust.firstname as fname, cust.lastname as lname, cust.phone as phone, cust.email as email, cust.username as username, cust.activestatus as accountstatus, acc.accno as accountno, acc.balance as Balance from customerdetails cust, account acc where cust.username=:username and acc.username=:username",
        resultSetMapping = "Mapping.viewresultusername")
@SqlResultSetMapping(
        name="Mapping.viewresultusername",
        classes={
                @ConstructorResult(
                        targetClass=com.example.Banking.Models.viewtoadmin.class,
                        columns={
                                @ColumnResult(name="fname"),
                                @ColumnResult(name="lname"),
                                @ColumnResult(name="phone"),
                                @ColumnResult(name="email"),
                                @ColumnResult(name="username"),
                                @ColumnResult(name="accountstatus"),
                                @ColumnResult(name="accountno"),
                                @ColumnResult(name="Balance")
                        })})

@NamedNativeQuery(name = "getdetails",
        query = "select cust.username as username, acc.accno as accnono, acc.balance as Balance from customerdetails cust, account acc where cust.username=:username and acc.username=:username",
        resultSetMapping = "Mapping.viewresultgetdetails")
@SqlResultSetMapping(
        name="Mapping.viewresultgetdetails",
        classes={
                @ConstructorResult(
                        targetClass=com.example.Banking.Models.viewtocustomer.class,
                        columns={
                                @ColumnResult(name="username"),
                                @ColumnResult(name="accnono"),
                                @ColumnResult(name="Balance"),
                        })})
public class CustomerDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String firstname;
    private String lastname;
    private String fathername;
    private String gender;
    private long phone;
    private String address;
    private String email;
    private String username;
    private String password;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private Date dob;
    private String identitytype;
    private Long identityno;
    private Long adharno;
    @Column(columnDefinition = "boolean default fasle")
    private boolean accountstatus;
    @Column(columnDefinition = "boolean default false")
    private boolean activestatus;

    public boolean isAccountstatus() {
        return accountstatus;
    }

    public void setAccountstatus(boolean accountstatus) {
        this.accountstatus = accountstatus;
    }

    public boolean isActivestatus() {
        return activestatus;
    }

    public void setActivestatus(boolean activestatus) {
        this.activestatus = activestatus;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFathername() {
        return fathername;
    }

    public void setFathername(String fathername) {
        this.fathername = fathername;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getIdentitytype() {
        return identitytype;
    }

    public void setIdentitytype(String identitytype) {
        this.identitytype = identitytype;
    }

    public Long getIdentityno() {
        return identityno;
    }

    public void setIdentityno(Long identityno) {
        this.identityno = identityno;
    }

    public Long getAdharno() {
        return adharno;
    }

    public void setAdharno(Long adharno) {
        this.adharno = adharno;
    }


}
