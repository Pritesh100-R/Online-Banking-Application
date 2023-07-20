package com.example.Banking.Services.IMplementation;

import com.example.Banking.Models.Transfer;
import com.example.Banking.Repositrories.Transferhistory;
import com.example.Banking.Services.transferservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Service
public class transferserviceimpl implements transferservice {
    @Autowired
    Transferhistory trepo;
    @Override
    public Transfer addAction(long saccount, long raccount, int amount) {
        LocalDate today = LocalDate.now();
        Transfer transfer=new Transfer();
        transfer.setSaccount(saccount);
        transfer.setRaccount(raccount);
        transfer.setAmount(amount);
        transfer.setDate(today);
        return trepo.save(transfer);
    }

    @Override
    public List<Transfer> getTransfers(long account) {
        List<Transfer> sender=trepo.findBySaccount(account);
        List<Transfer> receiver=trepo.findByRaccount(account);
        List<Transfer> merged=new ArrayList<>();
        merged.addAll(sender);
        merged.addAll(receiver);
        Collections.sort(merged);
        return merged;
    }
}
