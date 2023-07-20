package com.example.Banking.Repositrories;

import com.example.Banking.Models.Accountdetails;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface Accountrepo extends CrudRepository<Accountdetails, Integer> {
    @Query(value="select * from account where username=:username", nativeQuery = true)
    public Accountdetails findByUsername(@Param(value="username") String username);
//    @Query(name ="findbyusername", nativeQuery = true)
//    public Accountdetails findByUsername(@Param(value="username") String username);
//    @Query(name ="findbyaccno", nativeQuery = true)
//    public Accountdetails findByAccno(@Param(value="accno") long accno);
    @Query(value="select * from account where accno=:accno", nativeQuery = true)
    public Accountdetails findByAccno(@Param(value="accno") long accno);

    @Transactional
    @Modifying
    @Query(value ="update account set balance=:balance where accno=:accno", nativeQuery = true)
    void updatebalance(@Param(value="balance") int balance, @Param(value="accno") long accno);
}
