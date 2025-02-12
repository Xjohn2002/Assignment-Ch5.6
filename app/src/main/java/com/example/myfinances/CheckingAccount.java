package com.example.myfinances;

public class CheckingAccount {
    private int accountNumber;
    private double currentBalance;
    public CheckingAccount(int accountNumber,double currentBalance){
        this.accountNumber = accountNumber;
        this.currentBalance = currentBalance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }
    public double getCurrentBalance(){
        return currentBalance;
    }
}
