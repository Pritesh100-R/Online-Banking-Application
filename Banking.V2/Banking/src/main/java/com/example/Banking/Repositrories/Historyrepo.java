package com.example.Banking.Repositrories;

import com.example.Banking.Models.History;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Historyrepo extends CrudRepository<History, Integer> {
//    @Query(name="history", nativeQuery = true)
//    List<History> gethistorybyacc(@Param(value="accno") long accno);
    @Query(value="select * from history where account=:accno", nativeQuery = true)
    public List<History> gethistorybyacc(@Param(value="accno") long accno);
}
