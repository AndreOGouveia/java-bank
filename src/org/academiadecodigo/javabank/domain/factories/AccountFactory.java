package org.academiadecodigo.javabank.domain.factories;

import org.academiadecodigo.javabank.domain.accounts.Account;
import org.academiadecodigo.javabank.domain.accounts.AccountType;
import org.academiadecodigo.javabank.domain.accounts.CheckingAccount;
import org.academiadecodigo.javabank.domain.accounts.SavingsAccount;

public class AccountFactory {

     public Account openAccount(AccountType accountType,int id){
        switch (accountType){
            case SAVINGS:
                return new SavingsAccount(id);

            case CHECKING:
                return  new CheckingAccount(id);

            default:
                return new CheckingAccount(id);
        }
     }


}
