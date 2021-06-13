package com.practice.bankapp.model;

import java.util.*;

public class Client implements Report {
    private final String name;
    private final List<Account> accounts = new ArrayList<>();

    private Account activeAccount;
    private float initialOverdraft; //кредитная карта/возможность уходить в минус
    private float initialBalance; //баланс изначально
    private final Gender gender;

    StringBuilder arrayBalance = new StringBuilder();


    public Client(String name, float initialOverdraft, Gender gender) {
        this.name = name;
        this.initialOverdraft = initialOverdraft;
        this.gender = gender;
    }

    public Client(String name, Gender gender) {
        this(name, 0, gender);
    }

    public float getInitialBalance() {
        return initialBalance;
    }

    public void setInitialBalance(float initialBalance) {
        this.initialBalance = initialBalance;

    }

    public float getInitialOverdraft() {
        return initialOverdraft;
    }

    public void setInitialOverdraft(float initialOverdraft) {
        this.initialOverdraft = initialOverdraft;
    }

    public void setActiveAccount(Account activeAccount) {
        this.activeAccount = activeAccount;
        arrayBalance.append(activeAccount);
    }

    public Account getActiveAccount() {
        return activeAccount;
    }

    public String getName() {
        return this.name;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void printReport() {
        System.out.println("Name : " + this.getClientSalutation() + " " + name);
        for (Account a : accounts) {
            System.out.print(a.getAccountName() + " balance: " + a.getBalance()
                    + " ");
        }
        System.out.println();

    }

    private String getClientSalutation() {
        return gender.getSalutation();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return name.equals(client.name) &&
                gender == client.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, gender);
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                '}';
    }
}
