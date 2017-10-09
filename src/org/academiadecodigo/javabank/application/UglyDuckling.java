package org.academiadecodigo.javabank.application;
import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.javabank.controller.*;
import org.academiadecodigo.javabank.model.AccountManager;
import org.academiadecodigo.javabank.model.Bank;
import org.academiadecodigo.javabank.view.*;
import sun.nio.cs.ext.MacArabic;

import java.util.HashMap;
import java.util.Map;

public class UglyDuckling {




    public UglyDuckling(Bank bank, Prompt prompt){

        // initialization of view and controller for menu
        MenuView menuView = new MenuView(bank,prompt);
        MenuController menuController = new MenuController(bank);
        menuView.setMenuController(menuController);
        menuController.setMenuView(menuView);

        // initialization of view and controller for Login

        LoginController loginController = new LoginController(bank);
        LoginView loginView = new LoginView(bank,prompt);
        loginController.setNextController(menuController);
        loginView.setLoginController(loginController);
        loginController.setLoginView(loginView);


        // initialization of view and controller for balance

        BalanceView balanceView = new BalanceView(bank,prompt);
        BalanceController balanceController = new BalanceController(bank);
        balanceController.setBalanceView(balanceView);
        balanceController.setNextController(menuController);
        balanceView.setBalanceController(balanceController);


        // initialization of view and controller for simple transaction credit

        TransactionView depositView = new TransactionView(bank,prompt);
        DepositController depositController = new DepositController(bank);
        depositController.setNextController(menuController);
        depositView.setAbstractTransactionController(depositController);
        depositController.setTransactionView(depositView);

        // initialization of view and controller for simple transaction debit
        TransactionView withdrawalView = new TransactionView(bank,prompt);
        WithdrawalController withdrawalController = new WithdrawalController(bank);
        withdrawalController.setNextController(menuController);
        withdrawalView.setAbstractTransactionController(withdrawalController);
        withdrawalController.setTransactionView(withdrawalView);


        // initialization of view and controller for opening accounts

        OpenAccountView openAccountView = new OpenAccountView(bank, prompt);
        OpenAccountController openAccountController = new OpenAccountController(bank);
        openAccountController.setAccountManager(bank.getAccountManager());
        openAccountController.setOpenAccountView(openAccountView);
        openAccountController.setNextController(menuController);
        openAccountView.setOpenAccountController(openAccountController);

        // initialization of view and controller for transfer between accounts

        TransferView transferView = new TransferView(bank,prompt);
        TransferController transferController = new TransferController(bank);
        transferController.setNextController(menuController);
        transferController.setTransferView(transferView);
        transferView.setTransferController(transferController);


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
