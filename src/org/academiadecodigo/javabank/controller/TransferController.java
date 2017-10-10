package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.javabank.services.AccountService;
import org.academiadecodigo.javabank.services.CustomerService;
import org.academiadecodigo.javabank.view.TransferView;

public class TransferController extends AbstractController {

    TransferView transferView;
    AccountService accountService;

    public TransferController(CustomerService customerService) {
        super(customerService);
    }

    @Override
    public void init() {
        transferView.show();
        nextController.init();
    }

    public void doTransfer(int originAcc, int destinationAcc, Double amount){
        accountService.transfer(originAcc,destinationAcc,amount);

    }

    public void setTransferView(TransferView transferView) {
        this.transferView = transferView;
    }

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }
}
