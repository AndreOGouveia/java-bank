package org.academiadecodigo.javabank.test;

import org.academiadecodigo.javabank.domain.*;
import org.academiadecodigo.javabank.domain.accounts.Account;
import org.academiadecodigo.javabank.domain.accounts.AccountType;
import org.academiadecodigo.javabank.domain.managers.AccountManager;

public class CustomerTest {

    public boolean test() {

        AccountManager acman = new AccountManager();
        Customer customer = new Customer(acman,1,"André");

        // customer should start with zero balance
        if (customer.getBalance() != 0) {
            return false;
        }


        int a1 = customer.createAccount(AccountType.CHECKING);
        int a2 = customer.createAccount(AccountType.SAVINGS);

        customer.deposit(a1,100);
        customer.deposit(a2,120);


        // customer should be able to see his total balance
        if (customer.getBalance() != 220) {
            return false;
        }

        // customer must keep a min balance on savings account
        customer.transfer(a2, a1, 30);
        if (acman.getBalance(a2)  != 120) {
            return false;
        }

        // customer must be able to perform transfers between accounts
        customer.transfer(a2, a1, 20);
        if (acman.getBalance(a2) != 100 || acman.getBalance(a1) != 120) {
            return false;
        }

        // customer can not withdraw from savings account
        customer.withdraw(a2, 100);
        if (acman.getBalance(a2) != 100) {
            return false;
        }

        return true;
    }
}
