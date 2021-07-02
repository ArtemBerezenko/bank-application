package com.practice.bankapp.model;

import java.util.Objects;

public abstract class AbstractAccount implements Account {
	protected float balance;

	@Override
	public void printReport() {
		System.out.println("Account balance: " + balance);
	}

	@Override
	public void deposit(float x) throws IllegalArgumentException {
		if (x >= 0) {
			balance += x;
		} else {
			throw new IllegalArgumentException();
		}
	}

	@Override
	public float getBalance() {
		return balance;
	}

	public int decimalValue(){ return Math.round(balance); }


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		AbstractAccount that = (AbstractAccount) o;
		return Float.compare(that.balance, balance) == 0;
	}

	@Override
	public int hashCode() {
		return Objects.hash(balance);
	}

	@Override
	public String toString() {
		return "Account{" +
				"balance=" + balance +
				'}';
	}
}
