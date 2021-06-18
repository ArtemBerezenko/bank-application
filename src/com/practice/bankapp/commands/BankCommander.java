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
            new FindClientCommand(),
            new DepositCommand(),
            new WithdrawCommand(),
            new TransferCommand(),
            new ExitCommand()
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
// ctrl + K = коммит