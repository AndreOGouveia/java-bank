package org.academiadecodigo.javabank.domain.managers;

import org.academiadecodigo.javabank.domain.accounts.Account;
import org.academiadecodigo.javabank.domain.accounts.AccountType;
import org.academiadecodigo.javabank.domain.accounts.CheckingAccount;
import org.academiadecodigo.javabank.domain.accounts.SavingsAccount;
import org.academiadecodigo.javabank.domain.factories.AccountFactory;

import java.util.HashMap;
import java.util.Map;

public class AccountManager {

    public static int numberOfAccounts = 0;
    public static final int MIN_SAVINGS_BALANCE = 100;

    private Map<Integer, Account> accounts = new HashMap<>();


    public Account openAccount(AccountType accountType){

        Account newAccount;
        AccountFactory accountFactory = new AccountFactory();
        newAccount  = accountFactory.openAccount(accountType,++numberOfAccounts);
        return newAccount;
    }


    public double getBalance(int id) {
        return accounts.get(id).getBalance();
    }

    public double getBalance() {

        double balance = 0;

        for (Account account : accounts.values()) {
            balance += account.getBalance();
        }

        return balance;
    }

    public void deposit(int id, double amount) {
        accounts.get(id).credit(amount);
    }

    public void withdraw(int id, double amount) {

        Account account = accounts.get(id);

        if (account instanceof SavingsAccount) {
            return;
        }

        account.debit(amount);

    }

    public void transfer(int srcId, int destId, double amount) {

        Account srcAccount = accounts.get(srcId);
        Account dstAccount = accounts.get(destId);

        // if there is no balance in src account do nothing
        if (srcAccount.getBalance() < amount) {
            return;
        }

        // if src account is savings, we need to keep a minimum balance
        if ((srcAccount instanceof SavingsAccount) &&
                (srcAccount.getBalance() < MIN_SAVINGS_BALANCE + amount)) {
            return;
        }

        srcAccount.debit(amount);
        dstAccount.credit(amount);

    }



}
