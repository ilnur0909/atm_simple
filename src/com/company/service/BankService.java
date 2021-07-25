package com.company.service;

import com.company.model.BankAccount;

import java.math.BigDecimal;

public interface BankService {

    BankAccount getClient(final String accountNumber, final String pinCode);

    void withdrawFunds(BankAccount account, final BigDecimal amount);

    void depositFunds(BankAccount account, final BigDecimal amount);

    void setPinCode(BankAccount account, final String pincode);

    String getPinCode(final BankAccount account);

    String getAccountNumber(final BankAccount account);

    BigDecimal getBalance(final BankAccount account);

    String getAccountData(final BankAccount account);
}