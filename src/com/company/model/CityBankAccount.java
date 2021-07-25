package com.company.model;

import java.math.BigDecimal;


public class CityBankAccount extends BankAccount {

    private String name;
    private String surname;

    public CityBankAccount(final String name, final String surname,
                           final String accountNumber, final String pinCode, final BigDecimal balance) {
        super(accountNumber, pinCode, balance);
        this.name = name;
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "CityBankAccount{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", accountNumber='" + getAccountNumber() + '\'' +
                ", pinCode='" + getPinCode() + '\'' +
                ", balance=" + getBalance() +
                '}';
    }
}