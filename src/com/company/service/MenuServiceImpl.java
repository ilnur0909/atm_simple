package com.company.service;

import com.company.model.BankAccount;
import com.company.model.CityBankAccount;

import java.math.BigDecimal;
import java.util.Scanner;

public class MenuServiceImpl implements MenuService {

    private Integer tax;
    private BankService bankService;
    private Scanner scanner;
    private Integer selector;

    public MenuServiceImpl(Scanner scanner, BankService bankService) {
        this.scanner = scanner;
        this.bankService = bankService;
        this.tax = 200;
    }

    public MenuServiceImpl(Scanner scanner, BankService bankService, Integer tax) {
        this.scanner = scanner;
        this.bankService = bankService;
        this.tax = tax;
    }

    @Override
    public void showMenu(BankAccount client) {
        if (client instanceof CityBankAccount){
            cityBankMenu(client);
        } else{
            nationalBankMenu(client);
        }
    }


    private void cityBankMenu(BankAccount client){
        do {
            printCityBankMenu();
            selector = scanner.nextInt();
            switch (selector){
                case 1:
                    withdraw(client);
                    break;
                case 2:
                    viewBalance(client);
                    break;
                case 3:
                    changePin(client);
                    break;
                case 4:
                    deposit(client);
                    break;
                case 5:
                    viewAccountData(client);
                    break;
            }
        }
        while(!selector.equals(6));
    }

    private void printCityBankMenu(){
        System.out.println("\nPRESS [1] TO WITHDRAW FUNDS\n" +
                "PRESS [2] TO VIEW BALANCE\n" +
                "PRESS [3] TO CHANGE PIN CODE\n" +
                "PRESS [4] TO DEPOSIT FUNDS IN ACCOUNT\n" +
                "PRESS [5] TO VIEW ACCOUNT DATA\n" +
                "PRESS [6] TO EXIT");
    }

    private void withdraw(BankAccount client) {
        System.out.println("Insert amount: (fee " + tax + " tenge)");
        System.out.println("Enter 0 to exit");
        BigDecimal amount = scanner.nextBigDecimal();

        if (amount.compareTo(BigDecimal.valueOf(0)) > 0) {
            bankService.withdrawFunds(client, amount.add(BigDecimal.valueOf(tax)));
        }
    }

    private void viewBalance(final BankAccount client) {
        System.out.println("Balance: " + client.getBalance());
    }

    private void changePin(BankAccount client) {
        System.out.println("Enter pin code: ");
        String pinCode = scanner.next();
        client.setPinCode(pinCode);
    }

    private void deposit(BankAccount client) {
        System.out.println("Insert amount: ");
        System.out.println("Enter 0 to exit");
        BigDecimal amount = scanner.nextBigDecimal();

        if (amount.compareTo(BigDecimal.valueOf(0)) > 0) {
            bankService.depositFunds(client, amount);
        }
    }

    private void viewAccountData(final BankAccount client) {
        System.out.println(client.getAccountData());
    }

    private void nationalBankMenu(BankAccount client) {
        do{
            printNationalBankMenu();
            selector = scanner.nextInt();
            switch (selector){
                case 1:
                    withdraw(client);
                    break;
                case 2:
                    viewBalance(client);
                    break;
            }
        }
        while(!selector.equals(3));
    }


    private void printNationalBankMenu(){
        System.out.println("\nPRESS [1] TO CASH WITHDRAWAL\n" +
                "PRESS [2] TO VIEW BALANCE\n" +
                "PRESS [3] TO EXIT");
    }

    public Integer getTax() {
        return tax;
    }

    public void setTax(final Integer tax) {
        this.tax = tax;
    }

    public BankService getBankService() {
        return bankService;
    }
}
