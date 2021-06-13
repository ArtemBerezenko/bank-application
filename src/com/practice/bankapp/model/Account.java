package com.practice.bankapp.model;

import com.practice.bankapp.exceptions.NotEnoughFundsException;

public interface Account extends Report {
	 String getAccountName();
	 float getBalance();
	 void deposit(float x) throws IllegalArgumentException;
	 void withdraw(float x) throws NotEnoughFundsException;
	 int decimalValue();
}
