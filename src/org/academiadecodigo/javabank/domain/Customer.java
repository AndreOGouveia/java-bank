package org.academiadecodigo.javabank.domain;

public class Customer {

    private int customerNumber;
    private AccountManager accountManager;

    public Customer(AccountManager accountManager, int customerNumber) {
        this.accountManager = accountManager;
        this.customerNumber = customerNumber;
    }

    public int createAccount(AccountType accountType) {
       return accountManager.addAccount(accountType,customerNumber);
    }


    public double getBalance(){
        return accountManager.getCustomerBalance(customerNumber);
    }

    public double getBalance(int id) {
        return accountManager.getBalance(id);
    }


    public void deposit(int id, double amount) {
        accountManager.deposit(id, amount);
    }

    public void withdraw(int id, double amount) {
        accountManager.deposit(id,amount);
    }

    public void transfer(int srcId, int destId, double amount) {
        accountManager.transfer(srcId, destId, amount);
    }

}
