package org.academiadecodigo.model.account;

public class CheckingAccount extends Account {



    @Override
    public AccountType getAccountType() {
        return AccountType.CHECKING;
    }
}
