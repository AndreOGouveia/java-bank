package org.academiadecodigo.javabank.view;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerSetInputScanner;
import org.academiadecodigo.bootcamp.scanners.precisiondouble.DoubleInputScanner;
import org.academiadecodigo.javabank.controller.TransferController;
import org.academiadecodigo.javabank.model.Bank;
import org.academiadecodigo.javabank.utils.Messages;

public class TransferView extends AbstractView{

    TransferController transferController;

    public TransferView(Bank bank, Prompt prompt) {
        super(bank, prompt);
    }

    @Override
    public void show() {


        int originAccount = scanOriginAccount();
        int destinationAccount = scanDestinationAccount();
        double amount = scanAmount();
        transferController.doTransfer(originAccount,destinationAccount,amount);

    }

    protected int scanOriginAccount() {

        IntegerSetInputScanner scanner = new IntegerSetInputScanner(bank.getCustomer(bank.getActiveCustomer()).getAccountIds());
        scanner.setMessage(Messages.CHOOSE_ACCOUNT_ORIGIN);
        scanner.setError(Messages.ERROR_INVALID_ACCOUNT);

        return prompt.getUserInput(scanner);

    }
    protected int scanDestinationAccount() {

        IntegerSetInputScanner scanner = new IntegerSetInputScanner(bank.getAccountManager().getAccountIds());
        scanner.setMessage(Messages.CHOOSE_ACCOUNT_DESTINATION);
        scanner.setError(Messages.ERROR_INVALID_ACCOUNT);

        return prompt.getUserInput(scanner);

    }

    protected double scanAmount() {
        DoubleInputScanner scanner = new DoubleInputScanner();
        scanner.setMessage(Messages.CHOOSE_AMOUNT);
        scanner.setError(Messages.ERROR_INVALID_AMOUNT);

        return prompt.getUserInput(scanner);
    }

    public void setTransferController(TransferController transferController) {
        this.transferController = transferController;
    }
}
