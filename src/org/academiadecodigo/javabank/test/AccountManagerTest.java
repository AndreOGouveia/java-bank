package org.academiadecodigo.javabank.test;

import org.academiadecodigo.javabank.domain.*;

public class AccountManagerTest {
    
    public boolean test(){


        AccountManager accountManager = new AccountManager();

        int a1 = accountManager.addAccount(AccountType.CHECKING,1);
        int a2 = accountManager.addAccount(AccountType.SAVINGS,2);



        // accountManager should start with zero balance
        if (accountManager.getBalance() != 0) {
            return false;
        }


        accountManager.deposit(a1,100);
        accountManager.deposit(a2,120);

        //account manager should be able to deposit money in accounts
        if(accountManager.getBalance() != 220){
            return false;
        }




        // accountManager must keep a min balance on savings account
        accountManager.transfer(a2, a1, 30);
        if (accountManager.getBalance(a2) != 120) {
            return false;
        }

        // accountManager must be able to perform transfers between accounts
        accountManager.transfer(a2, a1, 20);
        if (accountManager.getBalance(a2) != 100 || accountManager.getBalance(a1) != 120) {
            return false;
        }

        // accountManager can not withdraw from savings account
        accountManager.withdraw(2, 100);
        if (accountManager.getBalance(a2) != 100) {
            return false;
        }

        int a3 = accountManager.addAccount(AccountType.CHECKING,2);
        accountManager.deposit(a3,100);


        // account manager should be able to calculate a clients total balance
        if(accountManager.getCustomerBalance(2)!=200){
            return false;
        }

        return true;
    }

}
