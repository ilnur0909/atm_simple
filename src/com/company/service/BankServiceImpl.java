package com.company.service;

import com.company.model.BankAccount;
import com.company.dao.Database;

import java.math.BigDecimal;

public class BankServiceImpl implements BankService {

    @Override
    public BankAccount getClient(final String accountNumber, final String pinCode) {
        BankAccount client = null;

        if (accountNumber != null && pinCode != null && !accountNumber.isBlank() && !pinCode.isBlank()) {

            for (BankAccount account : Database.getBankAccounts()) {
                if (account.getAccountNumber().equals(accountNumber) && account.getPinCode().equals(pinCode)) {
                    client = account;
                    break;
                }
            }
        }

        return client;
    }

    @Override
    public void withdrawFunds(BankAccount account, final BigDecimal amount) {
        if (amount.compareTo(BigDecimal.valueOf(0)) > 0) {
            BigDecimal balance = account.getBalance();

            if (amount.compareTo(balance) <= 0) {
                account.setBalance(balance.subtract(amount));
            } else {
                System.out.println("Insufficient funds on the account!");
            }
        }
    }

    @Override
    public void depositFunds(BankAccount account, final BigDecimal amount) {
        if (amount.compareTo(BigDecimal.valueOf(0)) > 0) {
            BigDecimal balance = account.getBalance();
            account.setBalance(balance.add(amount));
        }
    }

    @Override
    public void setPinCode(BankAccount account, final String pincode) {
        account.setPinCode(pincode);
    }

    @Override
    public String getAccountNumber(final BankAccount account) {
        return account.getAccountNumber();
    }

    @Override
    public String getPinCode(final BankAccount account) {
        return account.getPinCode();
    }

    @Override
    public BigDecimal getBalance(final BankAccount account) {
        return account.getBalance();
    }

    @Override
    public String getAccountData(final BankAccount account) {
        return account.getAccountData();
    }
}