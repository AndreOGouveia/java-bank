package org.academiadecodigo.javabank.services.jpa;

import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.persistence.JpaSessionManager;
import org.academiadecodigo.javabank.persistence.TransactionException;
import org.academiadecodigo.javabank.persistence.TransactionManager;
import org.academiadecodigo.javabank.persistence.dao.DaoAccount;
import org.academiadecodigo.javabank.persistence.dao.DaoCustomer;
import org.academiadecodigo.javabank.services.CustomerService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.*;

public class CustomerServiceImpl implements CustomerService {


    private TransactionManager tm;
    private DaoCustomer daoCustomer;

    public CustomerServiceImpl(TransactionManager tm, DaoCustomer daoCustomer) {

        this.daoCustomer = daoCustomer;
        this.tm = tm;
    }

    @Override
    public double getBalance(Integer id) {

        double balance = 0;
        try {
            tm.beginRead();
            Customer customer = daoCustomer.findById(id);
            if (customer == null) {
                tm.rollback();
                throw new IllegalArgumentException("invalid customer id");
            }
            List<Account> accounts = customer.getAccounts();


            for (Account account : accounts) {
                balance += account.getBalance();
            }

            tm.commit();


        } catch (TransactionException ex) {
            tm.rollback();
        }
        return balance;
    }

    @Override
    public Set<Integer> getCustomerAccountIds(Integer id) {
        Set<Integer> accountIds = new HashSet<>();
        try {
            tm.beginRead();

            Customer customer = daoCustomer.findById(id);
            if (customer == null) {
                tm.rollback();
                throw new IllegalArgumentException("invalid customer id");
            }
            List<Account> accounts = customer.getAccounts();

            for (Account account : accounts) {
                accountIds.add(account.getId());
            }

            tm.commit();


        } catch (TransactionException ex) {
            tm.rollback();
            throw new IllegalArgumentException("invalid customer id");

        }
        return accountIds;

    }

    @Override
    public Customer findById(int id) {

        try {
            tm.beginRead();
            Customer toReturn = daoCustomer.findById(id);
            tm.commit();
            return toReturn;
        }catch (TransactionException ex){
            tm.rollback();
            throw new IllegalArgumentException("invalid customer id");
        }

    }


}
