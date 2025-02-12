package com.example.myfinances;

public class Loan {
    private int accountNumber;
    private double currentBalance;
    private double initialBalance;
    private double interestRate;
    private double paymentAmount;

    public Loan(int accountNumber,double currentBalance,
                double initialBalance,double intrestRate,double paymentAmount){
        this.accountNumber = accountNumber;
        this.currentBalance = currentBalance;
        this.initialBalance = initialBalance;
        this.interestRate = intrestRate;
        this.paymentAmount = paymentAmount;
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

    public double getPaymentAmount() {
        return paymentAmount;
    }
}
