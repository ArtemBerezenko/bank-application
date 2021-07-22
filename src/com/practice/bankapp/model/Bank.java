package com.practice.bankapp.model;

import java.util.*;
import java.util.stream.Collectors;

import com.practice.bankapp.exceptions.ClientExistsException;
import com.practice.bankapp.service.BankService;
import com.practice.bankapp.service.BankServiceImpl;

public class Bank implements Report {
	protected Set<Client> clients = new HashSet<>();

	public void parseFeed(List<Map<String, String>> listOfMaps){
		BankService bankService = new BankServiceImpl();

		for(Map<String, String> oneOfMap : listOfMaps){
			Client client;
			Gender gender;
			Account account;
			String stringBalance = oneOfMap.get("balance");


			float currentBalance = Float.parseFloat(stringBalance);


			if(currentBalance < 0) continue;

			switch (oneOfMap.get("gender")) {
				case "m" -> gender = Gender.MALE;
				case "f" -> gender = Gender.FEMALE;
				default -> gender = null;
			};

			switch (oneOfMap.get("accountType")) {
				case "s" -> {
					client = new Client(oneOfMap.get("name"), gender, oneOfMap.get("city"));
					client.setInitialBalance(currentBalance);
					account = bankService.createAccount(client, "Saving");
					bankService.setActiveAccount(client, account);
				}
				case "c" -> {
					String stringOverdraft = oneOfMap.get("overdraft");
					float currentOverdraft = Float.parseFloat(stringOverdraft);
					client = new Client(oneOfMap.get("name"), currentOverdraft, gender, oneOfMap.get("city"));
					client.setInitialBalance(currentBalance);
					account = bankService.createAccount(client, "Checking");
					bankService.setActiveAccount(client, account);
				}
				default -> client = null;
			};

			try {
				bankService.addClient(this, client);
			} catch (ClientExistsException e) {
				System.out.println("Client with that name already exists");
			}

		}
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
		if (clients.contains(client)) {
			return true;
		}
		else return false;
	}

	public Set<Client> getClients() {
		return clients;
	}
}
