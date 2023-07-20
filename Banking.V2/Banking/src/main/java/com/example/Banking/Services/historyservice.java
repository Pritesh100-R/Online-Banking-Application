package com.example.Banking.Services;

import com.example.Banking.Models.History;

import java.util.List;

public interface historyservice {
    public History addAction(long account, int amount, int balance, String action);
    //public List<History> getHistory(long account);
    public List<History> getHistory(long account);
}
