package com.example.Banking.Repositrories;

import com.example.Banking.Models.CustomerDetails;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository

public interface CustomerRepo extends CrudRepository<CustomerDetails, Integer> {
    //@Transactional
    //@Modifying
    @Query(value = "select * from customerdetails where username =:username", nativeQuery = true)
    public CustomerDetails findbyusername(@Param(value= "username") String username);
//    @Query(value = "select count(username) from customerdetails where username = :username", nativeQuery = true)
//    public Integer findbyusername(@Param(value= "username") String username);
//    @Query(value = "Select customer FROM customerdetails customer WHERE customer.username=?1", nativeQuery = true)
//    public CustomerDetails findbyusername(String username);
    @Modifying
    @Transactional
    @Query(value = "update customerdetails set accountstatus=1 where username=:username", nativeQuery = true)
    void disableaccount(@Param(value ="username") String username);

    @Modifying
    @Transactional
    @Query(value = "update customerdetails set accountstatus=0 where username=:username", nativeQuery = true)
    void enableaccount(String username);

    @Modifying
    @Transactional
    @Query(value = "update customerdetails set activestatus=1 where username=:username", nativeQuery = true)
    void activateaccount(String username);

    @Modifying
    @Transactional
    @Query(value = "delete from customerdetails where username=:username", nativeQuery = true)
    void deleteaccount(String username);

    @Query(value = "select * from customerdetails where activestatus=false", nativeQuery = true)
    public List<CustomerDetails> finddeactiveaccounts();

    @Modifying
    @Transactional
    @Query(value="update customerdetails set password=:newpassword where password=:password", nativeQuery = true)
    public void updatepass(@Param(value="newpassword") String newpassword, @Param(value="password") String password);

}

