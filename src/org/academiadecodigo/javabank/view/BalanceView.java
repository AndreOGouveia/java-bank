package org.academiadecodigo.javabank.view;


import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.javabank.controller.BalanceController;
import org.academiadecodigo.javabank.model.Bank;
import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.utils.Messages;
import java.text.DecimalFormat;
import java.util.Set;


public class BalanceView extends AbstractView{


    BalanceController balanceController;
    DecimalFormat df = new DecimalFormat("#.##");

    public BalanceView(Bank bank, Prompt prompt) {
        super(bank, prompt);
    }


    @Override
    public void show() {

        System.out.println("\n" + bank.getCustomer(bank.getActiveCustomer()).getName() + Messages.BALANCE_MESSAGE + "\n");

        Set<Account> accounts = bank.getCustomer(bank.getActiveCustomer()).getAccounts();
        for (Account account: accounts) {
            System.out.println(account.getId() + "\t" + account.getAccountType() + "\t" + df.format(account.getBalance()));
        }

        System.out.println("\n\n" + Messages.BALANCE_TOTAL_MESSAGE + df.format(bank.getCustomer(bank.getActiveCustomer()).getBalance()));

    }


    public void setBalanceController(BalanceController balanceController) {
        this.balanceController = balanceController;
    }
}
