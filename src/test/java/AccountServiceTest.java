package test.java;

import main.java.model.account.Account;
import main.java.services.AccountService;
import main.java.services.AccountServiceImpl;
import main.java.model.account.CheckingAccount;
import main.java.model.account.SavingsAccount;

public class AccountServiceTest {

    public boolean test() {

        AccountService accountService = new AccountServiceImpl();
        Account ac = new CheckingAccount();
        Account as =  new SavingsAccount();
        accountService.add(ac);
        accountService.add(as);

        // should add ids
        if (ac.getId() == null || as.getId() == null) {
            return false;
        }

        // should be able to deposit
        accountService.deposit(ac.getId(), 10);
        accountService.deposit(as.getId(), SavingsAccount.MIN_BALANCE + 10);
        if (ac.getBalance() != 10 || as.getBalance() != SavingsAccount.MIN_BALANCE + 10) {
            return false;
        }

        // should be able to withdraw
        accountService.withdraw(ac.getId(), 1);
        if (ac.getBalance() != 9) {
            return false;
        }

        // should be able to transfer if sufficient funds are available
        accountService.transfer(as.getId(), ac.getId(), 1);
        if (ac.getBalance() != 10 || as.getBalance() != SavingsAccount.MIN_BALANCE + 9) {
            return false;
        }

        // should not be able to transfer if available funds are not sufficient in savings
        accountService.transfer(as.getId(), ac.getId(), 10);
        if (ac.getBalance() != 10 || as.getBalance() != SavingsAccount.MIN_BALANCE + 9) {
            return false;
        }

        // should not be able to transfer if available funds are not sufficient in checking
        accountService.transfer(ac.getId(), as.getId(), 11);
        if (ac.getBalance() != 10 || as.getBalance() != SavingsAccount.MIN_BALANCE + 9) {
            return false;
        }

        return true;
    }
}
