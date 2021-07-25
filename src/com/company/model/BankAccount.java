package com.company.model;

import java.math.BigDecimal;

public abstract class BankAccount {

    private String accountNumber;
    private String pinCode;
    private BigDecimal balance;

    public BankAccount(final String accountNumber, final String pinCode, final BigDecimal balance) {
        this.accountNumber = accountNumber;
        this.pinCode = pinCode;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getPinCode() {
        return pinCode;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public String getAccountData() {
        return toString();
    }

    public void setPinCode(final String pinCode) {
        this.pinCode = pinCode;
    }

    public void setBalance(final BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber='" + accountNumber + '\'' +
                ", pinCode='" + pinCode + '\'' +
                ", balance=" + balance +
                '}';
    }
}