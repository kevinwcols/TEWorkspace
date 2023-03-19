package com.techelevator;

import java.util.ArrayList;

public class BankCustomer {
    private String name;
    private String address;
    private String phoneNumber;
    private ArrayList<Accountable> accounts = new ArrayList<>();

    // Getters
    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public Accountable[] getAccounts() {
        Accountable[] acc = new Accountable[this.accounts.size()];
        for (int i = 0; i < this.accounts.size(); i++) {
            acc[i] = this.accounts.get(i);
        }
        return acc;
    }

    public void addAccount(Accountable newAccounts) {
        accounts.add(newAccounts);
    }

    // Setters
    public void setName(String newName) {
        this.name = newName;
    }

    public void setAddress(String newAddress) {
        this.address = newAddress;
    }

    public void setPhoneNumber(String newPhoneNumber) {
        this.phoneNumber = newPhoneNumber;
    }

    public void setAccounts(ArrayList<Accountable> newAccounts) {
        this.accounts = newAccounts;
    }

    public boolean isVip() {
        int total = 0;
        for (int i = 0; i < this.accounts.size(); i++) {
            Accountable curAcc = this.accounts.get(i);
            total = total + curAcc.getBalance();
        }
        if (total >= 25000) {
            return true;
        } else {
            return false;
        }
    }

}
