package com.practice.bankapp.commands;

import com.practice.bankapp.exceptions.OverDraftLimitExceededException;
import com.practice.bankapp.model.Account;
import com.practice.bankapp.model.Client;

import java.util.List;
import java.util.Set;

public class Operations extends BankCommander {

    public static void findSomeAccount(String searchWord) {
        Set<Account> accounts = Client.getAccounts();
        Set<Client> clients = currentBank.getClients();
        for (Client client : clients) {
            if (searchWord.equals(client.getName())) {
                currentClient = client;
            }
        }
    }

    public static void depositSomeClient(float amount) {
        bankService.deposit(currentClient, amount);
    }

    public static void withdrawSomeClient(float amount) {
        try {
            bankService.withdraw(currentClient, amount);
        } catch (OverDraftLimitExceededException e) {
            System.out.println(e.getMessage());
        }
    }

}
