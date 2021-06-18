package com.practice.bankapp.commands;

import java.util.Scanner;

public class WithdrawCommand extends BankCommander implements Command{
    @Override
    public void execute() {
        Scanner in = new Scanner(System.in);
        System.out.print("Input amount: ");
        float amount = in.nextFloat();
        Operations.withdrawSomeClient(amount);
    }

    @Override
    public void printCommandInfo() {
        System.out.println("Withdraw");
    }
}
