package org.academiadecodigo.javabank.view;


import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.javabank.controller.BalanceController;
import org.academiadecodigo.javabank.services.CustomerService;
import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.utils.Messages;
import java.text.DecimalFormat;
import java.util.Set;


public class BalanceView extends AbstractView{


    BalanceController balanceController;
    DecimalFormat df = new DecimalFormat("#.##");

    public BalanceView(CustomerService customerService, Prompt prompt) {
        super(customerService, prompt);
    }


    @Override
    public void show() {

        System.out.println("\n" + customerService.getCustomer(customerService.getActiveCustomer()).getName() + Messages.BALANCE_MESSAGE + "\n");

        Set<Account> accounts = customerService.getCustomer(customerService.getActiveCustomer()).getAccounts();
        for (Account account: accounts) {
            System.out.println(account.getId() + "\t" + account.getAccountType() + "\t" + df.format(account.getBalance()));
        }

        System.out.println("\n\n" + Messages.BALANCE_TOTAL_MESSAGE + df.format(customerService.getCustomer(customerService.getActiveCustomer()).getBalance()));

    }


    public void setBalanceController(BalanceController balanceController) {
        this.balanceController = balanceController;
    }
}
