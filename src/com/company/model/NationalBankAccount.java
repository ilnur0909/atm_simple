package com.company.model;

import java.math.BigDecimal;


public class NationalBankAccount extends BankAccount {

    private String fullName;

    public NationalBankAccount(final String fullName,
                               final String accountNumber, final String pinCode, final BigDecimal balance) {
        super(accountNumber, pinCode, balance);
        this.fullName = fullName;
    }


    @Override
    public String toString() {
        return "NationalBankAccount{" +
                "fullName='" + fullName + '\'' +
                ", accountNumber='" + getAccountNumber() + '\'' +
                ", pinCode='" + getPinCode() + '\'' +
                ", balance=" + getBalance() +
                '}';
    }
}