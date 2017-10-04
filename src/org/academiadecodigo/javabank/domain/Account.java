package org.academiadecodigo.javabank.domain;

public abstract class Account {

    private int customerNumber;
    private double balance = 0;
    private int id;

    public Account(int id, int customerNumber) {
        this.customerNumber = customerNumber;
        this.id = id;
    }

    public void credit(double amount) {
        balance += amount;
    }

    public void debit(double amount) {
        if (balance >= amount) {
            balance -= amount;
        }
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountType() {
        return this.getClass().getSimpleName();
    }

    public int getId() {
        return id;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }
}
