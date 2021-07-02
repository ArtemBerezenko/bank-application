package com.practice.bankapp.model;

import java.util.*;

public class Client implements Report{
    private final String name;
    private static final Set<Account> staticAccounts = new HashSet<Account>();
    private final Set<Account> nonStaticAccounts = new HashSet<Account>();

    private Account activeAccount;
    private float initialOverdraft; //кредитная карта/возможность уходить в минус
    private float initialBalance; //баланс изначально
    private final Gender gender;
    private final String city;

    public Client(String name, float initialOverdraft, Gender gender, String city) {
        this.name = name;
        this.initialOverdraft = initialOverdraft;
        this.gender = gender;
        this.city = city;
    }

    public Client(String name, Gender gender, String city) {
        this(name, 0, gender, city);
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
    }

    public Account getActiveAccount() {
        return activeAccount;
    }

    public String getName() {
        return this.name;
    }

    public String getCity() { return this.city; }

    //public void setCity(String city) { this.city = city; }

    public static Set<Account> getAccounts() {
        return staticAccounts;
    }

    public void addAccount(Account account) {
        staticAccounts.add(account);
        nonStaticAccounts.add(account);
    }

    public void printReport() {
        System.out.println("Name : " + this.getClientSalutation() + " " + name);
        for (Account a : nonStaticAccounts) {
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
        return Float.compare(client.initialOverdraft, initialOverdraft) == 0 && Float.compare(client.initialBalance, initialBalance) == 0 && name.equals(client.name) && Objects.equals(nonStaticAccounts, client.nonStaticAccounts) && Objects.equals(activeAccount, client.activeAccount) && gender == client.gender && city.equals(client.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, nonStaticAccounts, activeAccount, initialOverdraft, initialBalance, gender, city);
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", balance=" + activeAccount.getBalance() +
                ", initialOverdraft=" + initialOverdraft +
                ", gender=" + gender +
                ", city='" + city + '\'' +
                '}';
    }

    public Gender getGender() {
        return gender;
    }
}
