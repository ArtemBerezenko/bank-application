package com.practice.bankapp.commands;

import java.util.Scanner;

public class FindClientCommand extends BankCommander implements Command {
    @Override
    public void execute() {
        Scanner in = new Scanner(System.in);
        System.out.print("Input client: ");
        String searchWord = in.nextLine();
        Operations.findSomeClient(searchWord);
        System.out.println(currentClient.toString());
    }

    @Override
    public void printCommandInfo() {
        System.out.println("Find");
    }
}
