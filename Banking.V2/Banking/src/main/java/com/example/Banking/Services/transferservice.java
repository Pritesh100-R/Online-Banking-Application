package com.example.Banking.Services;

import com.example.Banking.Models.Transfer;

import java.util.List;

public interface transferservice {
    public Transfer addAction(long saccount, long raccount, int amount);
    public List<Transfer> getTransfers(long account);
}
