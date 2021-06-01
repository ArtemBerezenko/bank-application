package com.practice.bankapp.service;

import com.practice.bankapp.exceptions.ClientExistsException;
import com.practice.bankapp.exceptions.NotEnoughFundsException;
import com.practice.bankapp.exceptions.OverDraftLimitExceededException;
import com.practice.bankapp.model.*;

public class BankServiceImpl implements BankService {

	@Override
	public void addClient(Bank bank, Client client) throws ClientExistsException {
		bank.addClient(client);
	}

	@Override
	public void removeClient(Bank bank, Client client) {
		bank.removeClient(client);
	}

	@Override
	public void setActiveAccount(Client client, Account account) {
		client.setActiveAccount(account);
	}

    @Override
    public Account createAccount(Client client, String accountType) {
        Account account;
        switch (accountType) {
            case "Saving" -> account = new SavingAccount(client.getInitialBalance());
            case "Checking" -> account = new CheckingAccount(client.getInitialBalance(), client.getInitialOverdraft());
            default -> account = null;
        };
        client.addAccount(account);
        return account;
    }

    @Override
    public void deposit(Client client, float x) {
        Account activeAccount = client.getActiveAccount();
        activeAccount.deposit(x);
	}

    @Override
    public void withdraw(Client client, float x) throws OverDraftLimitExceededException {
        Account activeAccount = client.getActiveAccount();
	    try {
            activeAccount.withdraw(x);
        } catch (NotEnoughFundsException e) {
            throw new OverDraftLimitExceededException("Is not enough money", activeAccount.getBalance());
        }
    }

}
