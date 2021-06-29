package com.practice.bankapp.commands;

public class ExitCommand extends BankCommander implements Command{
    @Override
    public void execute() {
        System.exit(0);
    }

    @Override
    public void printCommandInfo() {
        System.out.println("Exit");
    }
}
