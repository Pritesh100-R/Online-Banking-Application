package com.example.Banking.Repositrories;

import com.example.Banking.Models.Transfer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface Transferhistory extends CrudRepository<Transfer, Integer> {
    @Query(value="select * from transfer where saccount=:saccount", nativeQuery = true)
    public List<Transfer> findBySaccount(@Param(value="saccount") long saccount);
    @Query(value="select * from transfer where raccount=:raccount", nativeQuery = true)
    public List<Transfer> findByRaccount(@Param(value="raccount") long raccount);
    //@Query(name="saccount", nativeQuery = true)
    //public List<Transfer> findBySaccount(@Param(value="saccount") long saccount);
//    @Query(name="raccount", nativeQuery = true)
//    public List<Transfer> findByRaccount(@Param(value="raccount") long raccount);
}
