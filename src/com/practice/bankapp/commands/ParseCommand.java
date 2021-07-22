package com.practice.bankapp.commands;

import com.practice.bankapp.model.BankFeedService;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ParseCommand extends BankCommander implements Command {
    @Override
    public void execute() {
        BankFeedService bankFeed = new BankFeedService();
        File file = new File("feeds/clients.feed");
        try {
            List<Map<String, String>> list = bankFeed.loadFeed(file);
            currentBank.parseFeed(list);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void printCommandInfo() {
        System.out.println("Parse file");
    }
}
