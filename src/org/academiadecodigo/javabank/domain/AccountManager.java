package org.academiadecodigo.javabank.domain;

import java.util.HashMap;
import java.util.Map;

public class AccountManager {

    public static final int MIN_SAVINGS_BALANCE = 100;

    private Map<Integer, Account> accounts = new HashMap<>();


    public int addAccount(AccountType accountType, int customerNumber){

        Account newAccount;

        if(accountType == AccountType.SAVINGS){
            newAccount = new SavingsAccount(accounts.size()+1,  customerNumber);
        }
        else{
            newAccount = new CheckingAccount(accounts.size()+1,customerNumber);
        }

        accounts.put(newAccount.getId(), newAccount);
        return newAccount.getId();
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

    public double getCustomerBalance(int customerNumber){

        double balance =0;
        for (Account acc : accounts.values()){

            if(acc.getCustomerNumber() == customerNumber){
                balance+=acc.getBalance();
            }
        }

        return balance;
    }

}
