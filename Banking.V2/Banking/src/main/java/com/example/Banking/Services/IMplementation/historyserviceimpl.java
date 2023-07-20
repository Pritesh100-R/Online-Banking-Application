package com.example.Banking.Services.IMplementation;

import com.example.Banking.Models.History;
import com.example.Banking.Repositrories.Historyrepo;
import com.example.Banking.Services.historyservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class historyserviceimpl implements historyservice {
    @Autowired
    Historyrepo hrepo;
    @Override
    public History addAction(long account, int amount, int balance, String action) {
        LocalDate today = LocalDate.now();

        History row=new History();
        row.setAccount(account);
        row.setAction(action);
        row.setAmount(amount);
        row.setDate(today);
        return hrepo.save(row);
    }

    @Override
    public List<History> getHistory(long account) {
        return hrepo.gethistorybyacc(account);
    }

    //@Override
//    public List<History> getHistory(long account) {
//        return hrepo.gethistorybyacc(account);
//    }
}
