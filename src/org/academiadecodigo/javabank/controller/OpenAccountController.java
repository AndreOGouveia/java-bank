package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.javabank.model.AccountManager;
import org.academiadecodigo.javabank.model.Bank;
import org.academiadecodigo.javabank.model.account.AccountType;
import org.academiadecodigo.javabank.view.OpenAccountView;

public class OpenAccountController extends AbstractController{

    AccountManager accountManager;
    OpenAccountView openAccountView;

    public OpenAccountController(Bank bank) {
        super(bank);
    }



    @Override
    public void init() {
        openAccountView.show();
    }

    public void openAccountType(int choice){

        bank.getCustomer(bank.getActiveCustomer()).addAccount(accountManager.openAccount(AccountType.values()[choice-1]));
        nextController.init();

    }

    public void setAccountManager(AccountManager accountManager) {
        this.accountManager = accountManager;
    }

    public void setOpenAccountView(OpenAccountView openAccountView) {
        this.openAccountView = openAccountView;
    }
}
