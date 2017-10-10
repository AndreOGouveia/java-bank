package org.academiadecodigo.javabank;


import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.javabank.application.UglyDuckling;
import org.academiadecodigo.javabank.services.AccountService;
import org.academiadecodigo.javabank.services.CustomerService;
import org.academiadecodigo.javabank.model.Customer;


public class App {

    public static void main(String[] args) {

        CustomerService customerService = new CustomerService();
        AccountService accountService = new AccountService();
        customerService.setAccountService(accountService);

        Customer c1 = new Customer(1,"Rui");
        Customer c2 = new Customer(2,"Sergio");
        Customer c3 = new Customer(3,"Bruno");
        customerService.addCustomer(c1);
        customerService.addCustomer(c2);
        customerService.addCustomer(c3);
        Prompt prompt = new Prompt(System.in,System.out);

        UglyDuckling app = new UglyDuckling(customerService,prompt);
/*
        BankApplication bankApplication = new BankApplication(customerService,);
        bankApplication.start();*/
    }
}
