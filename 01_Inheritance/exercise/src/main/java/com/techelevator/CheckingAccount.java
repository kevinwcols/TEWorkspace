package com.techelevator;

public class CheckingAccount extends BankAccount {
    // constructor
    public CheckingAccount(String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber);
    }

    public CheckingAccount(String accountHolderName, String accountNumber, int balance) {
        super(accountHolderName, accountNumber, balance);
    }

    // Override method
    // if balance < 0 but greater than -$100.00, a $10.00 overdraft fee is also charged against the account.
    // overdraft up to $100 (not including $10 overdraft fee)
    // if overdraft > 100 then transfer fails balance = balance
    public int withdraw(int amountToWithdraw) {
        int newBalance = getBalance() - amountToWithdraw;
        if (newBalance > -100) {
            super.withdraw(amountToWithdraw);

            // deduct the overdraft fee $10.0 if balance becomes negative
            if (newBalance < 0) {
                super.withdraw(10);
            }
        }
        return getBalance();
    }
}
