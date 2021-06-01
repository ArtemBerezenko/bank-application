package com.practice.bankapp.service;

import com.practice.bankapp.exceptions.ClientExistsException;
import com.practice.bankapp.exceptions.OverDraftLimitExceededException;
import com.practice.bankapp.model.Account;
import com.practice.bankapp.model.Bank;
import com.practice.bankapp.model.Client;

public interface BankService {
	void addClient(Bank bank, Client client) throws ClientExistsException;
	void removeClient(Bank bank, Client client);
	Account createAccount(Client client, String account);
	void setActiveAccount(Client client, Account account);
    void deposit(Client client, float x);
    void withdraw(Client client, float x) throws OverDraftLimitExceededException;
}
