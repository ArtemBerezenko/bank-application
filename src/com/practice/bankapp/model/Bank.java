package com.practice.bankapp.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.practice.bankapp.exceptions.ClientExistsException;
import com.practice.bankapp.service.BankService;
import com.practice.bankapp.service.BankServiceImpl;

public class Bank implements Report {
    //protected static List<Client> clients = new ArrayList<>(); //сделать сет и могласовать иквалс и хэшкод
	protected static Set<Client> clients = new HashSet<>();

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
		if (clients.contains(client)) {
			return true;
		}
		else return false;
	}

	public Set<Client> getClients() {
		return clients;
	}
}


