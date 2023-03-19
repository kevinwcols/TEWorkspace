package com.techelevator;

public class SavingsAccount extends BankAccount {

    // constructor
    public SavingsAccount(String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber);
    }

    public SavingsAccount(String accountHolderName, String accountNumber, int balance) {
        super(accountHolderName, accountNumber, balance);
    }

    //Override method
    public int withdraw(int amountToWithdraw) {
        int currentBalance = getBalance();
        // withdrawal only happens when withdrawal amount is less than or equal to the balance
        if (amountToWithdraw <= getBalance()) {
            super.withdraw(amountToWithdraw);
            // If the remaining balance is less than $150 when a withdrawal is made, an
            // additional $2 service charge is withdrawn from the account.
            if (getBalance() < 150) {
                super.withdraw(2);
            }
            if (getBalance() < 0) {
                currentBalance = currentBalance + 1;
                super.deposit(currentBalance);
            }
        }
        return getBalance();
    }
}
