package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.javabank.services.AccountService;
import org.academiadecodigo.javabank.services.CustomerService;
import org.academiadecodigo.javabank.model.account.AccountType;
import org.academiadecodigo.javabank.view.OpenAccountView;

public class OpenAccountController extends AbstractController{

    AccountService accountService;
    OpenAccountView openAccountView;

    public OpenAccountController(CustomerService customerService) {
        super(customerService);
    }



    @Override
    public void init() {
        openAccountView.show();
        nextController.init();
    }

    public void openAccountType(int choice){

        customerService.getCustomer(customerService.getActiveCustomer()).addAccount(accountService.openAccount(AccountType.values()[choice-1]));


    }

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    public void setOpenAccountView(OpenAccountView openAccountView) {
        this.openAccountView = openAccountView;
    }
}
