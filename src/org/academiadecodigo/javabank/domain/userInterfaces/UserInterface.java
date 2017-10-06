package org.academiadecodigo.javabank.domain.userInterfaces;


import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerInputScanner;
import org.academiadecodigo.javabank.domain.Bank;
import org.academiadecodigo.javabank.domain.Customer;
import org.academiadecodigo.javabank.domain.managers.AccountManager;

public class UserInterface {

    public static void main(String[] args) {
        Bank bank = new Bank();
        AccountManager accountManager = new AccountManager();
        Prompt prompt = new Prompt(System.in, System.out);
        MenuInicial init;
        IntegerInputScanner integerInputScanner = new IntegerInputScanner();

        Customer c1 = new Customer(accountManager, 0, "Joana");
        Customer c2 = new Customer(accountManager, 1, "André");

        bank.addCustomer(c1);
        bank.addCustomer(c2);


        while (true) {


            int customerNumber = prompt.getUserInput(integerInputScanner);


            System.out.println("Hi," + bank.getCustomer(customerNumber).getCustomerName() + "!");
            init = new MenuInicial(bank.getCustomer(customerNumber), accountManager, prompt);
            init.start();


        }

    }


}



}
