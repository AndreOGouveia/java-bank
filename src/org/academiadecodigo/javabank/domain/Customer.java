package org.academiadecodigo.javabank.domain;

import org.academiadecodigo.javabank.domain.accounts.Account;
import org.academiadecodigo.javabank.domain.accounts.AccountType;
import org.academiadecodigo.javabank.domain.managers.AccountManager;

import java.util.HashMap;
import java.util.Map;

public class Customer {

    private Map<Integer, Account> accounts = new HashMap<>();
    private int customerNumber;
    private AccountManager accountManager;
    private String customerName;

    public Customer(AccountManager accountManager, int customerNumber, String customerName) {
        this.accountManager = accountManager;
        this.customerNumber = customerNumber;
        this.customerName = customerName;
    }

    public int createAccount(AccountType accountType) {
        Account newAccount = accountManager.openAccount(accountType);
        accounts.put(newAccount.getId(),newAccount);

       return newAccount.getId();

    }

    public double getBalance(){
       double balance =0;
       for(Account acc : accounts.values()){
           balance+= acc.getBalance();
       }
       return balance;
    }

    public double getBalance(int id) {
        return accountManager.getBalance(id);
    }

    public void deposit(int id, double amount) {
        accountManager.deposit(id, amount);
    }

    public void withdraw(int id, double amount) {
        accountManager.withdraw(id,amount);
    }

    public void transfer(int srcId, int destId, double amount) {
        accountManager.transfer(srcId, destId, amount);
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getCustomerNumber(){
        return customerNumber;
    }
}
