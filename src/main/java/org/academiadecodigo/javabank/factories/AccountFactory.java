package org.academiadecodigo.javabank.factories;

import org.academiadecodigo.model.account.Account;
import org.academiadecodigo.model.account.AccountType;
import org.academiadecodigo.model.account.CheckingAccount;
import org.academiadecodigo.model.account.SavingsAccount;

public class AccountFactory {

    public Account createAccount(AccountType accountType) {

        Account newAccount;
        switch (accountType) {
            case CHECKING:
                newAccount = new CheckingAccount();
                break;
            case SAVINGS:
                newAccount = new SavingsAccount();
                break;
            default:
                newAccount = null;

        }

        return newAccount;
    }
}