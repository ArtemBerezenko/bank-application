package com.practice.bankapp.commands;

import com.practice.bankapp.model.BankReport;

public class AccountNumberCommand extends BankCommander implements Command{

    @Override
    public void execute() { System.out.println(bank.getAccountNumber(currentBank)); }

    @Override
    public void printCommandInfo() { System.out.println("Number of accounts"); }
}
