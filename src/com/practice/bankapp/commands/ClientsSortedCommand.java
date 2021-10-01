package com.practice.bankapp.commands;

import com.practice.bankapp.model.BankReport;
import com.practice.bankapp.model.Client;

import java.util.List;

public class ClientsSortedCommand extends BankCommander implements Command {

    @Override
    public void execute() {
        List<Client> clients = bank.getClientsSorted(currentBank);
        int index = 4;

        for (Client c : clients) {
            System.out.println("Name: " + c.getName() + ", Balance: " + c.getInitialBalance() + ", Overdraft: " + c.getInitialOverdraft());
        }
    }

    @Override
    public void printCommandInfo() {
        System.out.println("Sorted clients");
    }
}
