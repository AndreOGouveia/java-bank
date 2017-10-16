package org.academiadecodigo.javabank.services;

import org.academiadecodigo.model.Customer;
import org.academiadecodigo.model.account.Account;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.RollbackException;

public class JPAAccountServiceImpl implements AccountService {

    private EntityManagerFactory emf;


    public JPAAccountServiceImpl(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public Account add(Account account) {

        EntityManager em = emf.createEntityManager();

        try {

            em.getTransaction().begin();
            Account savedAccount = em.merge(account);
            em.getTransaction().commit();
            return savedAccount;

        }catch (RollbackException ex){
            em.getTransaction().rollback();
            return null;
        } finally {

            if (em != null) {
                em.close();
            }
        }

    }

    @Override
    public void deposit(int id, double amount) {


    }

    @Override
    public void withdraw(int id, double amount) {

    }

    @Override
    public void transfer(int srcId, int dstId, double amount) {

    }
}
