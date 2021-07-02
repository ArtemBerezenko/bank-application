package com.practice.bankapp.commands;

import com.practice.bankapp.model.BankReport;

public class ClientsSortedCommand extends BankCommander implements Command{

    @Override
    public void execute() { System.out.println(bank.getClientsSorted()); }

    @Override
    public void printCommandInfo() { System.out.println("Sorted clients"); }
}
