package com.practice.bankapp.commands;

import com.practice.bankapp.exceptions.OverDraftLimitExceededException;
import com.practice.bankapp.model.Client;

import java.util.List;

public class Operations extends BankCommander{

    public static void findSomeClient(String searchWord) {
        List<Client> clients = currentBank.getClients();
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
        try{
            bankService.withdraw(currentClient, amount);
        }
        catch(OverDraftLimitExceededException e) {
            System.out.println(e.getMessage());
        }
    }

}
