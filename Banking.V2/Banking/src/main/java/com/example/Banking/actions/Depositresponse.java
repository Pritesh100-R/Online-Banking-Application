package com.example.Banking.actions;

public class Depositresponse {
    private boolean depositStatus;
    private String responseMessage;
    private long account;
    public boolean isDepositStatus() {
        return depositStatus;
    }

    public void setDepositStatus(boolean depositStatus) {
        this.depositStatus = depositStatus;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public long getAccount() {
        return account;
    }

    public void setAccount(long account) {
        this.account = account;
    }


}
