package org.academiadecodigo.javabank.application;
import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.javabank.controller.*;
import org.academiadecodigo.javabank.model.AccountManager;
import org.academiadecodigo.javabank.model.Bank;
import org.academiadecodigo.javabank.view.*;

public class UglyDuckling {




    public UglyDuckling(Bank bank, Prompt prompt, AccountManager accountManager){

        LoginController loginController = new LoginController(bank);
        LoginView loginView = new LoginView(bank,prompt);
        MenuView menuView = new MenuView(bank,prompt);
        MenuController menuController = new MenuController(bank);

        BalanceView balanceView = new BalanceView(bank,prompt);
        BalanceController balanceController = new BalanceController(bank);
        balanceController.setBalanceView(balanceView);
        balanceController.setNextController(menuController);




        TransactionView depositView = new TransactionView(bank,prompt);
        TransactionView withdrawalView = new TransactionView(bank,prompt);

        DepositController depositController = new DepositController(bank);
        WithdrawalController withdrawalController = new WithdrawalController(bank);


        depositController.setNextController(menuController);
        withdrawalController.setNextController(menuController);


        depositView.setAbstractTransactionController(depositController);
        withdrawalView.setAbstractTransactionController(withdrawalController);






        OpenAccountView openAccountView = new OpenAccountView(bank, prompt);
        TransferView transferView = new TransferView(bank,prompt);

        loginController.setLoginView(loginView);
        loginView.setLoginController(loginController);




        MenuController menuController = new MenuController();


        loginController.setNextController(menuController);













    }







}
