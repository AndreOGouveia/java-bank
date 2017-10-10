package org.academiadecodigo.javabank.view;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerSetInputScanner;
import org.academiadecodigo.bootcamp.scanners.precisiondouble.DoubleInputScanner;
import org.academiadecodigo.javabank.controller.transactions.AbstractTransactionController;
import org.academiadecodigo.javabank.services.CustomerService;
import org.academiadecodigo.javabank.utils.Messages;

public class TransactionView extends AbstractView {

    protected AbstractTransactionController abstractTransactionController;


    public TransactionView(CustomerService customerService, Prompt prompt) {
        super(customerService, prompt);
    }

    @Override
    public void show() {

        if (!hasAccounts()) {
            System.out.println("\n" + Messages.ERROR_NO_ACCOUNT);
            return;
        }

        System.out.println(Messages.OPEN_ACCOUNTS+buildAccountList());
        int accountNumber = scanAccount();
        double amount = scanAmount();


        abstractTransactionController.doTransaction(accountNumber,amount);


    }

    public void setAbstractTransactionController(AbstractTransactionController abstractTransactionController) {
        this.abstractTransactionController = abstractTransactionController;
    }


    private String buildAccountList() {

        StringBuilder builder = new StringBuilder();

        for (Integer id : customerService.getCustomer(customerService.getActiveCustomer()).getAccountIds()) {
            builder.append(id);
            builder.append(" ");
        }

        return builder.toString();
    }

    protected boolean hasAccounts() {
        return customerService.getCustomer(customerService.getActiveCustomer()).getAccountIds().size() > 0;
    }

    protected int scanAccount() {

        IntegerSetInputScanner scanner = new IntegerSetInputScanner(customerService.getCustomer(customerService.getActiveCustomer()).getAccountIds());
        scanner.setMessage(Messages.CHOOSE_ACCOUNT);
        scanner.setError(Messages.ERROR_INVALID_ACCOUNT);

        return prompt.getUserInput(scanner);

    }

    protected double scanAmount() {
        DoubleInputScanner scanner = new DoubleInputScanner();
        scanner.setMessage(Messages.CHOOSE_AMOUNT);
        scanner.setError(Messages.ERROR_INVALID_AMOUNT);

        return prompt.getUserInput(scanner);
    }

}
