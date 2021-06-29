package com.practice.bankapp.commands;

import java.util.Scanner;

public class TransferCommand extends BankCommander implements Command {
    @Override
    public void execute() {
        Scanner in = new Scanner(System.in);
        System.out.print("Transfer amount: ");
        float amount = in.nextFloat();
        Operations.withdrawSomeClient(amount);
        Scanner newIn = new Scanner(System.in);
        System.out.print("Recipient: ");
        String searchWord = newIn.nextLine();
        Operations.findSomeClient(searchWord);
        Operations.depositSomeClient(amount);
    }

    @Override
    public void printCommandInfo() {
        System.out.println("Transfer");
    }
}
