package org.academiadecodigo.javabank.application.operations;

import org.academiadecodigo.javabank.view.BankApplication;
import org.academiadecodigo.javabank.model.Customer;

public abstract class AbstractBankOperation implements Operation {

    protected BankApplication bankApplication;
    protected Customer customer;

    public AbstractBankOperation(BankApplication bankApplication) {
        this.bankApplication = bankApplication;
        customer = bankApplication.getBank().getCustomer(bankApplication.getAcessingCustomerId());
    }
}
