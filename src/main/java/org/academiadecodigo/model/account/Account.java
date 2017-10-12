package org.academiadecodigo.model.account;

import org.academiadecodigo.model.Model;

public interface Account extends Model {

    AccountType getAccountType();

    double getBalance();

    void credit(double amount);

    void debit(double amount);

    boolean canDebit(double amount);

    boolean canCredit(double amount);

}