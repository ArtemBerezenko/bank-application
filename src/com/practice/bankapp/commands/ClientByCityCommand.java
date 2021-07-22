package com.practice.bankapp.commands;

import com.practice.bankapp.model.BankReport;
import com.practice.bankapp.model.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ClientByCityCommand extends BankCommander implements Command{

    @Override
    public void execute() {
        Map<String, List<Client>>  cityClients = bank.getClientsByCity(currentBank);
        for (Map.Entry<String, List<Client>> entry : cityClients.entrySet()) {
            List<Client> list = new ArrayList<>(entry.getValue());
            System.out.println("City: " + entry.getKey());
            for(Client mapClient: list) System.out.println(mapClient);
            System.out.println();
        }
    }

    @Override
    public void printCommandInfo() { System.out.println("Sorted clients by city"); }
}
