package com.example.Banking.Repositrories;

import com.example.Banking.Models.CustomerDetails;
import com.example.Banking.Models.viewtoadmin;
import com.example.Banking.Models.viewtocustomer;
import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.SqlResultSetMapping;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//@NamedNativeQuery(name = "getalluser",
//        query = "select cust.firstname as fname, cust.lastname as lname, cust.phone as phone, cust.email as email, cust.username as username, cust.activetstatus as accountstatus, acc.accno as accountno, acc.balance as Balance from customerdetails cust, account acc where cust.username=acc.username",
//        resultSetMapping = "Mapping.viewresult")
//@SqlResultSetMapping(
//        name="Mapping.viewresult",
//        classes={
//                @ConstructorResult(
//                        targetClass=com.example.Banking.Models.viewtoadmin.class,
//                        columns={
//                                @ColumnResult(name="fname"),
//                                @ColumnResult(name="lname"),
//                                @ColumnResult(name="phone"),
//                                @ColumnResult(name="email"),
//                                @ColumnResult(name="username"),
//                                @ColumnResult(name="accountstatus"),
//                                @ColumnResult(name="accountno"),
//                                @ColumnResult(name="Balance")
//                        })})
public interface viewrepo extends CrudRepository<CustomerDetails, Integer> {
//    @Query(value = "SELECT * com.example.Banking.Models.viewtoadmin (Customer.fname,Customer.lname,Customer.phone,Customer.username,Customer.accountstatus,acc.accountno,acc.Balance)" + "FROM CustomerDetails Customer ,Accountdetails acc WHERE Customer.username=acc.username", nativeQuery = true)
//    public List<viewtoadmin> getallcustomers();
//    @Query(value= "select new com.example.Banking.Models.viewtoadmin(cust.firstname, cust.lastname, cust.phone, cust.email, cust.username, cust.accountstatus, acc.accno, acc.balance)" + "from customerdetails cust, account acc where cust.username=acc.username", nativeQuery = true)
//    public List<viewtoadmin> getallcustomers();

//    @Query(value= "select cust.firstname, cust.lastname, cust.phone, cust.email, cust.username, acc.accno, acc.balance from customerdetails cust, account acc", nativeQuery = true)
//    public List<viewtoadmin> getallcustomers();

//    @Query("SELECT new com.example.Banking.Models.viewtoadmin(u.fname,u.lname,u.phone,u.username,u.status,u.featureStatus,a.accno,a.balance,s.accno,s.balance)" + "FROM User u ,Account a,Saccount s WHERE u.username=?1 and u.username=a.username and u.username=s.username")
//    public viewtoadmin getUserDetailsByUsername(String userDetail);
//
//    @Query("SELECT new com.example.Banking.Models.viewtoadmin(u.fname,u.lname,u.phone,u.username,u.status,u.featureStatus,a.accno,a.balance,s.accno,s.balance)" + "FROM User u ,Account a,Saccount s WHERE s.accno=?1 and u.username=a.username and u.username=s.username")
//    public viewtoadmin getUserDetailsByAccountNo(long accNo);
    @Query(name="getAllUser", nativeQuery = true)
    public List<viewtoadmin> getAllUser();
    @Query(name="getcustomerbyusername", nativeQuery = true)
    public viewtoadmin getcustomerbyusername(@Param(value="username") String username);
//    @Query(name="getcustomerbyid", nativeQuery = true)
//    public viewtoadmin getcustomerbyid(@Param(value="id") Integer id);
    @Query(name="getdetails", nativeQuery = true)
    public viewtocustomer getdetails(@Param(value="username") String username);
}
