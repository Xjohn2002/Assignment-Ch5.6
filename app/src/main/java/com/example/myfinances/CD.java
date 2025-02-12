package com.example.myfinances;

public class CD {
    private int accountNumber;
    private double currentBalance;
    private double initialBalance;
    private double interestRate;

    public CD(int accountNumber,double currentBalance, double initialBalance,double intrestRate){
        this.accountNumber = accountNumber;
        this.currentBalance = currentBalance;
        this.initialBalance = initialBalance;
        this.interestRate = intrestRate;
    }
    public int getAccountNumber() {
        return accountNumber;
    }
    public double getCurrentBalance(){
        return currentBalance;
    }

    public double getInitialBalance() {
        return initialBalance;
    }

    public double getInterestRate() {
        return interestRate;
    }
}
