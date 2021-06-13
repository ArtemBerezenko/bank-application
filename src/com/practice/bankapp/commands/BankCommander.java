package com.practice.bankapp.commands;

import com.practice.bankapp.model.Account;
import com.practice.bankapp.model.Bank;
import com.practice.bankapp.model.Client;
import com.practice.bankapp.model.Gender;
import com.practice.bankapp.service.BankService;
import com.practice.bankapp.service.BankServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankCommander extends Bank {
    public static Bank currentBank = new Bank();
    public static Command[] commands = {

            new Command() {
                public void execute() {
                    System.exit(0);
                }

                public void printCommandInfo() {
                    System.out.println("Exit");
                }
            },

            new Command() {
                public void execute() {
                    Scanner in = new Scanner(System.in);
                    System.out.print("Input client: ");
                    String searchWord = in.nextLine();
                    Client forFind = new Client(searchWord, null);
                    boolean check = currentBank.checkIfClientExists(forFind);
                    if (check) {
                        System.out.println(searchWord + " is found.");
                        List<Client> clients = currentBank.getClients();
                        Client currentClient = currentBank.getClient(forFind);
                        List<Account> accounts = currentClient.getAccounts();
                        Account currentAccount = accounts.get(0);
                        BankService bankService = new BankServiceImpl();
                        bankService.setActiveAccount(currentClient, currentAccount);
                    } else System.out.println(searchWord + " not found.");
                }

                public void printCommandInfo() {
                    System.out.println("Find");
                }

            },

            new Command() {
                public void execute() {


                }

                public void printCommandInfo() {
                    System.out.println("Deposit");
                }

            }
    };

    public static void printMenu() {
        System.out.println();
        for (int i = 0; i < commands.length; i++) {
            System.out.print(i + ") ");
            commands[i].printCommandInfo();
        }
    }
}
//паттерн команда