package org.academiadecodigo.javabank.controller.transactions;

import org.academiadecodigo.javabank.services.CustomerService;

public class WithdrawalController extends AbstractTransactionController {


    public WithdrawalController(CustomerService customerService) {
        super(customerService);
    }

    public void doTransaction(int accountNumber, double amount){
        customerService.getAccountService().withdraw(accountNumber,amount);
    }
}
