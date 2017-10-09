package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.javabank.model.Bank;
import org.academiadecodigo.javabank.view.LoginView;



public class LoginController extends AbstractController {

    LoginView loginView;

    public LoginController(Bank bank) {
        super(bank);
    }

    public void init(){
        loginView.show();
    }

    public void chooseCustomer(int customerNumber){

        bank.setActiveCustomer(customerNumber);
        nextController.init();
    }


    public void setLoginView(LoginView loginView) {
        this.loginView = loginView;
    }




}
