package com.practice.bankapp.commands;

import com.practice.bankapp.model.BankReport;

public class BankCreditSumCommand extends BankCommander implements Command{

    @Override
    public void execute() { System.out.println(bank.getBankCreditSum(currentBank)); }

    @Override
    public void printCommandInfo() { System.out.println("Total credit sum"); }
}
