package com.company;

import com.company.model.BankAccount;
import com.company.service.*;

import java.util.Scanner;

public class ATM {

    public static final BankService bankService = new BankServiceImpl();

    public static void main(String[] args) {

        var scanner = new Scanner(System.in);
        System.out.println("Enter your account number");
        String accountNumber = scanner.next();
        System.out.println("Enter your pincode");
        String pincode = scanner.next();

        BankAccount client = bankService.getClient(accountNumber, pincode);
        MenuService menuService = new MenuServiceImpl(scanner, bankService);

        if(client == null){
            System.out.println("Incorrect account number or pincode");
        } else{
            menuService.showMenu(client);
        }

    }
}
