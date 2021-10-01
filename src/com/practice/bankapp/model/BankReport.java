package com.practice.bankapp.model;


import com.practice.bankapp.commands.BankCommander;
import java.util.*;
import java.util.stream.Collectors;

public class BankReport {

    private float checkingSum;
    private int countOfAccounts;

    public int getNumberOfClients(Bank bank) {
        return bank.clients.size();
    }

    public int getAccountNumber(Bank bank) {
        for (Client c : bank.clients) {
            countOfAccounts += c.getAccounts().size();
        }
        return countOfAccounts;
    }

    public List<Client> getClientsSorted(Bank bank) {
        List<Client> result = bank.clients.stream()
                .sorted((o1, o2) -> Float.compare(o1.getInitialBalance(), o2.getInitialBalance()))
                .collect(Collectors.toList());
        return result;
    }

    public float getBankCreditSum(Bank bank) {
        for (Client client : bank.clients) {
            checkingSum += client.getInitialOverdraft();
        }
        return checkingSum;
    }

    public Map<String, List<Client>> getClientsByCity(Bank bank) {
        Map<String, List<Client>> clientsOfCity = new HashMap<>();
        List<String> city = new ArrayList<>();

        Set<String> set = bank.clients.stream()
                .map(Client::getCity).collect(Collectors.toSet());

        for (String c : set) {
            clientsOfCity.put(c, bank.clients.stream()
                    .filter(mc -> mc.getCity().equals(c))
                    .collect(Collectors.toList()));
        }
        return clientsOfCity;
    }
}
