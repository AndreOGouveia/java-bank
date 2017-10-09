package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.javabank.model.AccountManager;
import org.academiadecodigo.javabank.model.Bank;
import org.academiadecodigo.javabank.view.TransferView;

import java.math.BigDecimal;

public class TransferController extends AbstractController {

    TransferView transferView;
    AccountManager accountManager;

    public TransferController(Bank bank) {
        super(bank);
    }

    @Override
    public void init() {
        transferView.show();
    }

    public void doTransfer(int originAcc, int destinationAcc, Double amount){
        accountManager.transfer(originAcc,destinationAcc,amount);
        nextController.init();
    }

    public void setTransferView(TransferView transferView) {
        this.transferView = transferView;
    }

    public void setAccountManager(AccountManager accountManager) {
        this.accountManager = accountManager;
    }
}
