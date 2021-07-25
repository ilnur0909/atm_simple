package com.company.dao;

import java.math.BigDecimal;

import com.company.model.BankAccount;
import com.company.model.CityBankAccount;
import com.company.model.NationalBankAccount;

public class Database {

    private static BankAccount[] bankAccounts = new BankAccount[5];

    static {
        bankAccounts[0] = new CityBankAccount("Alex", "Smith","KZ112233", "7777", BigDecimal.valueOf(25_000));
        bankAccounts[1] = new CityBankAccount("Dave", "Davidson", "KZ5522233", "1234", BigDecimal.valueOf(65_000));
        bankAccounts[2] = new CityBankAccount("Ivan", "Ivanov", "KZ432158", "0505", BigDecimal.valueOf(2_000));
        bankAccounts[3] = new NationalBankAccount("Danil Karamazov", "KZ432122", "1235", BigDecimal.valueOf(2_000));
        bankAccounts[4] = new NationalBankAccount("Erbol Zhakishev", "KZ411111", "0101", BigDecimal.valueOf(2_000));
    }

    public static BankAccount[] getBankAccounts() {
        return bankAccounts;
    }
}