package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.services.AccountService;
import org.academiadecodigo.javabank.services.CustomerService;
import org.academiadecodigo.javabank.view.View;

public abstract class AbstractController implements Controller {

    protected View view;

    protected AccountService accountService;

    protected CustomerService customerService;

    public Customer getLoginCustomer(){
        return customerService.getLoginCustomer();
    }

    public void setView(View view) {
        this.view = view;
    }

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }


    public AccountService getAccountService() {
        return accountService;
    }

    public CustomerService getCustomerService() {
        return customerService;
    }



    @Override
    public void init() {
        view.show();
    }
}


