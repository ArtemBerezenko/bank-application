package com.practice.bankapp.commands;

import com.practice.bankapp.exceptions.OverDraftLimitExceededException;
import com.practice.bankapp.model.Account;
import com.practice.bankapp.model.Bank;
import com.practice.bankapp.model.Client;
import com.practice.bankapp.model.Gender;
import com.practice.bankapp.service.BankService;
import com.practice.bankapp.service.BankServiceImpl;

import java.util.*;

public class BankCommander extends Bank {
    public static Bank currentBank = new Bank();
    public static BankService bankService = new BankServiceImpl();
    public static Client currentClient;
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
                    Operations.findSomeClient(searchWord);
                    System.out.println(currentClient.toString());
                }

                public void printCommandInfo() {
                    System.out.println("Find");
                }
            },

            new Command() {
                public void execute() {
                    Scanner in = new Scanner(System.in);
                    System.out.print("Input amount: ");
                    float amount = in.nextFloat();
                    Operations.depositSomeClient(amount);
                }

                public void printCommandInfo() {
                    System.out.println("Deposit");
                }
            },

            new Command() {
                public void execute() {
                    Scanner in = new Scanner(System.in);
                    System.out.print("Input amount: ");
                    float amount = in.nextFloat();
                    Operations.withdrawSomeClient(amount);
                }

                public void printCommandInfo() {
                    System.out.println("Withdraw");
                }
            },

            new Command() {
                public void execute() {
                    Scanner in = new Scanner(System.in);
                    System.out.print("Transfer amount: ");
                    float amount = in.nextFloat();
                    Operations.withdrawSomeClient(amount);
                    Scanner newIn = new Scanner(System.in);
                    System.out.print("Recipient: ");
                    String searchWord = newIn.nextLine();
                    Operations.findSomeClient(searchWord);
                    Operations.depositSomeClient(amount);
                }

                public void printCommandInfo() {
                    System.out.println("Transfer");
                }
            }
    };

    public static void printMenu() {
//        List<Client> clients = List.of(new Client("a", Gender.MALE), new Client("b", Gender.MALE));
//        clients.sort(Comparator.comparing(Client::getName));
        System.out.println();
        for (int i = 0; i < commands.length; i++) {
            System.out.print(i + ") ");
            commands[i].printCommandInfo();
        }
    }
}
// паттерн команда
// ctrl + K = коммит