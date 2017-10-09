package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.javabank.model.Bank;
import org.academiadecodigo.javabank.view.TransactionView;

public class WithdrawalController extends AbstractTransactionController {


    TransactionView transactionView;

    public WithdrawalController(Bank bank) {
        super(bank);
    }

    @Override
    public void init() {
        transactionView.show();
    }

    @Override
    public void setTransactionView(TransactionView transactionView) {
        this.transactionView = transactionView;
    }

    public void doTransaction(int accountNumber, double amount){
        bank.getAccountManager().withdraw(accountNumber,amount);
        nextController.init();
    }
}
