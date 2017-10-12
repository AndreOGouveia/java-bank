package test.java;

import main.java.model.Customer;
import main.java.model.account.Account;
import main.java.services.CustomerService;
import main.java.services.CustomerServiceImpl;
import main.java.model.account.CheckingAccount;

import java.util.Set;

public class CustomerServiceTest {

    public boolean test() {

        CustomerService customerService = new CustomerServiceImpl();
        Customer c1 = new Customer();
        Customer c2 = new Customer();
        c1.setName("Rui");
        c2.setName("Sergio");
        Account account = new CheckingAccount();
        account.credit(100);
        c1.addAccount(account);
        c2.addAccount(account);

        customerService.add(c1);
        customerService.add(c2);

        // should add ids to org.academiadecodigo.model
        if (c1.getId() == null || c2.getId() == null) {
            return false;
        }

        // should get customer balance
        if (customerService.getBalance(c1.getId()) != account.getBalance() ||
                customerService.getBalance(c2.getId()) != account.getBalance()) {
            return false;
        }

        // should get all customer ids
        Set<Integer> cids = customerService.getCustomerIds();
        if (cids.size() != 2 || !cids.contains(c1.getId()) || !cids.contains(c2.getId())) {
            return false;
        }

        // should get customer account numbers
        Set<Integer> c1aids = customerService.getCustomerAccountNumbers(c1.getId());
        Set<Integer> c2aids = customerService.getCustomerAccountNumbers(c2.getId());
        if (c1aids.size() != 1 || c2aids.size() != 1 ||
                !c1aids.contains(account.getId()) || !c2aids.contains(account.getId())) {
            return false;
        }

        return true;
    }
}