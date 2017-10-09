package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.javabank.model.Bank;
import org.academiadecodigo.javabank.view.TransactionView;

public abstract class AbstractTransactionController extends AbstractController {

    TransactionView transactionView;

    public AbstractTransactionController(Bank bank) {
        super(bank);
    }

    public void setTransactionView(TransactionView transactionView) {
        this.transactionView = transactionView;
    }

     public abstract void doTransaction(int accountNumber, double ammount);

    public void goBack(){
        nextController.init();
    }

}
