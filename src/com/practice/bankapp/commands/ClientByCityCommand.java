package com.practice.bankapp.commands;

import com.practice.bankapp.model.BankReport;

public class ClientByCityCommand extends BankCommander implements Command{

    @Override
    public void execute() { System.out.println(bank.getClientsByCity()); }

    @Override
    public void printCommandInfo() { System.out.println("Sorted clients by city"); }
}
