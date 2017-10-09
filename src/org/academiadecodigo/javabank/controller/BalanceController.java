package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.javabank.model.Bank;
import org.academiadecodigo.javabank.view.BalanceView;

public class BalanceController extends AbstractController{


    BalanceView balanceView;

    public BalanceController(Bank bank) {
        super(bank);
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
