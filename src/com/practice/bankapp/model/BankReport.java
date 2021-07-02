package com.practice.bankapp.model;


import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class BankReport extends Bank{

    private final Set<Account> allAccounts = Client.getAccounts();
    private float checkingSum;
    private final Map<String, List<Client>> clientsOfCity = new HashMap<>();
    private final List<Client> listClients = new ArrayList<>(clients);

    public int getNumberOfClients() {
        return clients.size();
    }

    public int getAccountNumber() {
        return Client.getAccounts().size();
    }

    public List<Account> getClientsSorted() {
        List<Account> listOfAccounts = new ArrayList<Account>(allAccounts);
        Collections.sort(listOfAccounts, new Comparator<Account>() {
            public int compare(Account o1, Account o2) {
                return Float.compare(o1.getBalance(), o2.getBalance());
            }
        });

        return new ArrayList<Account>(listOfAccounts);
    }

    public float getBankCreditSum() {
        for (Client client : clients) {
            checkingSum += client.getInitialOverdraft();
        }
        return checkingSum;
    }

    public Map<String, List<Client>> getClientsByCity() {
        List<String> city = new ArrayList<>();

        for (int i = 0; i < listClients.size(); i++) {
            city.add(i, listClients.get(i).getCity());
        }

        Set<String> set = new LinkedHashSet<>(city);

        for (String c : set) {
            clientsOfCity.put(c, clients.stream()
                    .filter(mc -> mc.getCity().equals(c))
                    .collect(Collectors.toList()));
        }
        return clientsOfCity;
    }
}
