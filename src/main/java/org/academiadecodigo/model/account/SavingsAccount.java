package org.academiadecodigo.model.account;

public class SavingsAccount extends Account {

    public static final double MIN_BALANCE = 100;

    @Override
    public AccountType getAccountType() {
        return AccountType.SAVINGS;
    }

    @Override
    public boolean canDebit(double amount) {
        return super.canDebit(amount) && (getBalance() - amount) >= MIN_BALANCE;
    }
}
