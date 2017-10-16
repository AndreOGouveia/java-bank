package org.academiadecodigo.model.account;


import javax.persistence.Entity;

@Entity
public class CheckingAccount extends Account {



    @Override
    public AccountType getAccountType() {
        return AccountType.CHECKING;
    }
}
