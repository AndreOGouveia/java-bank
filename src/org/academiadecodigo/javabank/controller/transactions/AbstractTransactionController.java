package org.academiadecodigo.javabank.controller.transactions;

import org.academiadecodigo.javabank.controller.AbstractController;
import org.academiadecodigo.javabank.services.CustomerService;
import org.academiadecodigo.javabank.view.TransactionView;

public abstract class AbstractTransactionController extends AbstractController {

    TransactionView transactionView;

    public void init() {
        transactionView.show();
        nextController.init();
    }

    public AbstractTransactionController(CustomerService customerService) {
        super(customerService);
    }

    public void setTransactionView(TransactionView transactionView) {
        this.transactionView = transactionView;
    }

    public abstract void doTransaction(int accountNumber, double ammount);

}
