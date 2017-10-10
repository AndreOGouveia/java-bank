package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.javabank.services.CustomerService;
import org.academiadecodigo.javabank.view.BalanceView;

public class BalanceController extends AbstractController{


    BalanceView balanceView;

    public BalanceController(CustomerService customerService) {
        super(customerService);
    }

    @Override
    public void init() {
        balanceView.show();
        nextController.init();

    }

    public void setBalanceView(BalanceView balanceView) {
        this.balanceView = balanceView;
    }
}
