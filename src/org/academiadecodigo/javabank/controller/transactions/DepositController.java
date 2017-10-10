package org.academiadecodigo.javabank.controller.transactions;

import org.academiadecodigo.javabank.services.CustomerService;

public class DepositController extends AbstractTransactionController {


    public DepositController(CustomerService customerService) {
        super(customerService);
    }

    public void doTransaction(int accountNumber, double amount){
        customerService.getAccountService().deposit(accountNumber,amount);

    }
}
