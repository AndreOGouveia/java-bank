package org.academiadecodigo.javabank.test;

import org.academiadecodigo.javabank.domain.accounts.Account;
import org.academiadecodigo.javabank.domain.accounts.AccountType;
import org.academiadecodigo.javabank.domain.managers.AccountManager;

public class AccountManagerTest {
    
    public boolean test(){


        AccountManager accountManager = new AccountManager();

        Account a1 = accountManager.openAccount(AccountType.CHECKING);
        Account a2 = accountManager.openAccount(AccountType.SAVINGS);



        // accountManager should start with zero balance
        if (accountManager.getBalance() != 0) {
            return false;
        }


        accountManager.deposit(a1.getId(),100);
        accountManager.deposit(a2.getId(),120);

        //account manager should be able to deposit money in accounts
        if(accountManager.getBalance() != 220){
            return false;
        }




        // accountManager must keep a min balance on savings account
        accountManager.transfer(a2.getId(), a1.getId(), 30);
        if (accountManager.getBalance(a2.getId()) != 120) {
            return false;
        }

        // accountManager must be able to perform transfers between accounts
        accountManager.transfer(a2.getId(), a1.getId(), 20);
        if (accountManager.getBalance(a2.getId()) != 100 || accountManager.getBalance(a1.getId()) != 120) {
            return false;
        }

        // accountManager can not withdraw from savings account
        accountManager.withdraw(2, 100);
        if (accountManager.getBalance(a2.getId()) != 100) {
            return false;
        }



        return true;
    }

}
