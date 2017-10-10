package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.javabank.services.CustomerService;
import org.academiadecodigo.javabank.view.LoginView;



public class LoginController extends AbstractController {

    LoginView loginView;

    public LoginController(CustomerService customerService) {
        super(customerService);
    }

    public void init(){
        loginView.show();
        nextController.init();
    }

    public void chooseCustomer(int customerNumber){

        customerService.setActiveCustomer(customerNumber);

    }


    public void setLoginView(LoginView loginView) {
        this.loginView = loginView;
    }




}
