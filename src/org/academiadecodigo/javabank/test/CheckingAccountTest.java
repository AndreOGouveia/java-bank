package org.academiadecodigo.javabank.test;

import org.academiadecodigo.javabank.domain.accounts.Account;
import org.academiadecodigo.javabank.domain.accounts.CheckingAccount;

public class CheckingAccountTest {

    public boolean test(){


        Account account = new CheckingAccount(1);

        // checking account should start with zero money
        if (account.getBalance() != 0) {
            return false;
        }

        // we should be able to deposit money in checking account
        account.credit(80);
        if (account.getBalance() != 80) {
            return false;
        }

        // we should be able to take money from checking account
        account.debit(40);
        if (account.getBalance() != 40) {
            return  false;
        }

         // checking account should say it is a checking account
        if(!account.getAccountType().equals("CheckingAccount")){
            return false;
        }

        // savings account should be an instance of CheckingAccount
        if(!(account instanceof CheckingAccount)){
            return false;
        }

        return true;
    }

}
