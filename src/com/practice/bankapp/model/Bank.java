package com.practice.bankapp.model;

import java.util.ArrayList;
import java.util.List;

import com.practice.bankapp.exceptions.ClientExistsException;
import com.practice.bankapp.service.BankService;
import com.practice.bankapp.service.BankServiceImpl;

public class Bank implements Report {
    protected static List<Client> clients = new ArrayList<>();

	public List<Client> getClients() {
		return clients;
	}

	public void addClient(Client c) throws ClientExistsException {
		if (!checkIfClientExists(c)) {
			clients.add(c);
		} else {
			throw new ClientExistsException();
		}
	}

	public void removeClient(Client c) {
		clients.remove(c);
	}

	@Override
	public void printReport() {
		for (Client c : clients) {
			c.printReport();
		}
	}

	public boolean checkIfClientExists(Client client) {
		for (Client c : clients) {
			if (c.getName().equals(client.getName())) {
				return true;
			}
		}
		return false;
	}

	public Client getClient(Client client) {
		for (Client c : clients) {
			if (c.getName().equals(client.getName())) {
				return c;
			}
		}
		return client;
	}
}


