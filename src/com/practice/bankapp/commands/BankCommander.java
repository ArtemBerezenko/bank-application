package com.practice.bankapp.commands;

import com.practice.bankapp.model.Bank;
import com.practice.bankapp.model.Client;

public class BankCommander {
    public static Bank currentBank = new Bank();

    public static Command[] commands = {

            new Command() {
                public void execute() {
                    System.exit(0);
                }
                public void printCommandInfo() {
                    System.out.println("Exit");
                }
            }
    };

    public static void printMenu() {
        for (int i = 0; i < commands.length; i++) {
            System.out.print(i + ") ");
            commands[i].printCommandInfo();
        }
    }
}
