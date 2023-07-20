package com.example.Banking.Repositrories;

import com.example.Banking.Models.Checkbook;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface checkrepo extends CrudRepository<Checkbook, Integer> {
    @Query(value="select * from checkbook where account=:account", nativeQuery = true)
    public List<Checkbook> findByAccount(@Param(value="account") long account);
}
