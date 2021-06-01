package com.practice.bankapp;

import com.practice.bankapp.commands.BankCommander;
import com.practice.bankapp.exceptions.ClientExistsException;
import com.practice.bankapp.exceptions.OverDraftLimitExceededException;
import com.practice.bankapp.model.Account;
import com.practice.bankapp.model.Bank;
import com.practice.bankapp.model.Client;
import com.practice.bankapp.model.Gender;
import com.practice.bankapp.service.BankService;
import com.practice.bankapp.service.BankServiceImpl;

import java.util.Scanner;

public class BankApplication {
    static Client client1;
    static Client client2;
    static Bank bank = new Bank();

    public static void main(String[] args) {

        initialize(bank);
        modifyBank(client1, 0, 500);
        modifyBank(client2, 20, 0);
        printBankReport(bank);

        BankCommander.currentBank = bank;
        Scanner s = new Scanner(System.in);

        while (true) {
            BankCommander.printMenu();
            String commandString = s.nextLine();
            int command = Integer.parseInt(commandString);
            BankCommander.commands[command].execute();
        }

    }

    /*
     * Method that creates a few clients and initializes them with sample values
     */
    public static void initialize(Bank bank) {
        BankService bankService = new BankServiceImpl();
        client1 = new Client("Jonny Bravo", Gender.MALE);
        client1.setInitialBalance(1000);
        Account client1Account1 = bankService.createAccount(client1, "Saving");
        bankService.setActiveAccount(client1, client1Account1);

        client2 = new Client("Adam Sandler", 1000, Gender.MALE);
        client2.setInitialBalance(1000);
        Account client2Account1 =  bankService.createAccount(client2,"Checking");
        client2.setActiveAccount(client2Account1);

        System.out.println(client1.toString());
        System.out.println(client2.toString());


        try {
            bankService.addClient(bank, client1);
        } catch (ClientExistsException e) {
            System.out.println("Client with that name already exists");
        }
        try {
            bankService.addClient(bank, client2);
        } catch (ClientExistsException e) {
            System.out.println("Client with that name already exists");
        }

    }

    public static void modifyBank(Client client, float withdraw, float deposit) {
        BankService bankService = new BankServiceImpl();

        bankService.deposit(client, deposit);

        try {
            bankService.withdraw(client, withdraw);
        } catch (OverDraftLimitExceededException e) {
            System.out.println("Not enough funds: " + e.getMessage());
        }
    }

    public static void printBankReport(Bank bank) {
        bank.printReport();
    }

}
