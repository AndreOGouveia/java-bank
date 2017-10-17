package org.academiadecodigo.javabank.services.jpa;

import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.persistence.TransactionException;
import org.academiadecodigo.javabank.persistence.TransactionManager;
import org.academiadecodigo.javabank.persistence.dao.DaoAccount;
import org.academiadecodigo.javabank.services.AccountService;
import org.hibernate.HibernateException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.RollbackException;
import java.util.Collections;

public class AccountServiceImpl implements AccountService {

    private TransactionManager tm;
    private DaoAccount daoAccount;


    public AccountServiceImpl(TransactionManager tm , DaoAccount daoAccount) {
        this.daoAccount = daoAccount;
        this.tm =tm;

    }



    @Override
    public void deposit(Integer id, double amount) {

        try {
            tm.beginWrite();
            Account current = daoAccount.findById(id);
            if (current == null) {
                tm.rollback();
                throw new IllegalArgumentException("invalid account id");
            }

            current.credit(amount);
            daoAccount.saveOrUpdate(current);
            tm.commit();
        }catch (TransactionException ex) {
            tm.rollback();
        }

    }

    @Override
    public void withdraw(Integer id, double amount) {

        try {
            tm.beginWrite();
            Account current = daoAccount.findById(id);
            if (current == null) {
                tm.rollback();
                throw new IllegalArgumentException("invalid account id");
            }

            current.debit(amount);
            daoAccount.saveOrUpdate(current);
            tm.commit();
        }catch (TransactionException ex) {
            tm.rollback();
        }
    }

    @Override
    public void transfer(Integer srcId, Integer dstId, double amount) {

        try {
            tm.beginWrite();
            Account origin = daoAccount.findById(srcId);
            if (origin == null) {
                tm.rollback();
                throw new IllegalArgumentException("invalid origin account id");
            }
            Account destiny = daoAccount.findById(srcId);
            if (destiny == null) {
                tm.rollback();
                throw new IllegalArgumentException("invalid destiny account id");
            }

            origin.debit(amount);
            destiny.credit(amount);

            daoAccount.saveOrUpdate(origin);
            daoAccount.saveOrUpdate(destiny);
            tm.commit();
        } catch (TransactionException ex) {
            tm.rollback();
        }
    }

    public int addAccount(Account account){

        try {
            tm.beginWrite();


            account=daoAccount.saveOrUpdate(account);
            tm.commit();
            return account.getId();



        }catch (TransactionException ex){
            tm.rollback();
        }

        return 0;
    }
}

