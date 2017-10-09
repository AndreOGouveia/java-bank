package org.academiadecodigo.javabank;


import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.javabank.application.UglyDuckling;
import org.academiadecodigo.javabank.model.AccountManager;
import org.academiadecodigo.javabank.model.Bank;
import org.academiadecodigo.javabank.model.Customer;


public class App {

    public static void main(String[] args) {

        Bank bank = new Bank();
        AccountManager accountManager = new AccountManager();
        bank.setAccountManager(accountManager);

        Customer c1 = new Customer(1,"Rui");
        Customer c2 = new Customer(2,"Sergio");
        Customer c3 = new Customer(3,"Bruno");
        bank.addCustomer(c1);
        bank.addCustomer(c2);
        bank.addCustomer(c3);
        Prompt prompt = new Prompt(System.in,System.out);

        UglyDuckling app = new UglyDuckling(bank,prompt);
/*
        BankApplication bankApplication = new BankApplication(bank,);
        bankApplication.start();*/
    }
}
