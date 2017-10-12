package org.academiadecodigo.model;

import org.academiadecodigo.model.account.Account;

import java.util.ArrayList;
import java.util.List;

public class Customer extends AbstractModel {

    private String name;
    private List<Account> accounts = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void removeAccount(Account account) {
        accounts.remove(account);
    }

}

