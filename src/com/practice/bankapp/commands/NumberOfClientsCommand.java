package com.practice.bankapp.commands;

import com.practice.bankapp.model.BankReport;

public class NumberOfClientsCommand extends BankCommander implements Command{

    @Override
    public void execute() { System.out.println(bank.getNumberOfClients()); }

    @Override
    public void printCommandInfo() { System.out.println("Number of clients"); }
}
