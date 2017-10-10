package org.academiadecodigo.javabank.application;
import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.javabank.controller.*;
import org.academiadecodigo.javabank.controller.transactions.DepositController;
import org.academiadecodigo.javabank.controller.transactions.WithdrawalController;
import org.academiadecodigo.javabank.services.CustomerService;
import org.academiadecodigo.javabank.view.*;

import java.util.HashMap;
import java.util.Map;

public class UglyDuckling {




    public UglyDuckling(CustomerService customerService, Prompt prompt){

        // initialization of view and controller for menu
        MenuView menuView = new MenuView(customerService,prompt);
        MenuController menuController = new MenuController(customerService);
        menuView.setMenuController(menuController);
        menuController.setMenuView(menuView);

        // initialization of view and controller for Login

        LoginController loginController = new LoginController(customerService);
        LoginView loginView = new LoginView(customerService,prompt);
        loginController.setNextController(menuController);
        loginView.setLoginController(loginController);
        loginController.setLoginView(loginView);


        // initialization of view and controller for balance

        BalanceView balanceView = new BalanceView(customerService,prompt);
        BalanceController balanceController = new BalanceController(customerService);
        balanceController.setBalanceView(balanceView);
        balanceController.setNextController(menuController);
        balanceView.setBalanceController(balanceController);


        // initialization of view and controller for simple transaction credit

        TransactionView depositView = new TransactionView(customerService,prompt);
        DepositController depositController = new DepositController(customerService);
        depositController.setNextController(menuController);
        depositView.setAbstractTransactionController(depositController);
        depositController.setTransactionView(depositView);

        // initialization of view and controller for simple transaction debit
        TransactionView withdrawalView = new TransactionView(customerService,prompt);
        WithdrawalController withdrawalController = new WithdrawalController(customerService);
        withdrawalController.setNextController(menuController);
        withdrawalView.setAbstractTransactionController(withdrawalController);
        withdrawalController.setTransactionView(withdrawalView);


        // initialization of view and controller for opening accounts

        OpenAccountView openAccountView = new OpenAccountView(customerService, prompt);
        OpenAccountController openAccountController = new OpenAccountController(customerService);
        openAccountController.setAccountService(customerService.getAccountService());
        openAccountController.setOpenAccountView(openAccountView);
        openAccountController.setNextController(menuController);
        openAccountView.setOpenAccountController(openAccountController);

        // initialization of view and controller for transfer between accounts

        TransferView transferView = new TransferView(customerService,prompt);
        TransferController transferController = new TransferController(customerService);
        transferController.setNextController(menuController);
        transferController.setTransferView(transferView);
        transferView.setTransferController(transferController);
        transferController.setAccountService(customerService.getAccountService());


        Map<Integer,Controller> map = new HashMap<>();
        map.put(1,balanceController);
        map.put(2,depositController);
        map.put(3,withdrawalController);
        map.put(4,openAccountController);
        map.put(5,transferController);
        map.put(6,loginController);

        menuController.setControllerHashMap(map);


        loginController.init();

    }







}
