package org.academiadecodigo.javabank.test;

import org.academiadecodigo.javabank.domain.accounts.Account;
import org.academiadecodigo.javabank.domain.accounts.SavingsAccount;

public class SavingsAccountTest {

    public boolean test(){


        Account account = new SavingsAccount(1);

        // savings account should start with zero money
        if (account.getBalance() != 0) {
            return false;
        }

        // we should be able to deposit money in savings account
        account.credit(80);
        if (account.getBalance() != 80) {
            return false;
        }

        // we should be able to take money from savings account
        account.debit(40);
        if (account.getBalance() != 40) {
            return  false;
        }

        // savings account should be an instance of SavingsAccount
        if(!(account instanceof SavingsAccount)){
            return false;
        }

        // savings account should say it is a savings account
        if(!account.getAccountType().equals("SavingsAccount")){
            return false;
        }

        return true;
    }

}
