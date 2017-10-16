package org.academiadecodigo.javabank.services;

import org.academiadecodigo.model.Customer;
import org.academiadecodigo.model.account.Account;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.RollbackException;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.*;

public class JPACustomerServiceImpl implements CustomerService{


    private EntityManagerFactory emf;


    public JPACustomerServiceImpl(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public Customer add(Customer customer) {
        EntityManager em = emf.createEntityManager();

        try {

            em.getTransaction().begin();
            Customer savedC = em.merge(customer);
            em.getTransaction().commit();
            return savedC;

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
    public Customer findById(Integer id) {

        EntityManager em = emf.createEntityManager();


        try {

            // fetch a customer by id
            return em.find(Customer.class,id);

        } finally {

            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public List<Customer> findAll() {
        EntityManager em = emf.createEntityManager();
        try {

            // fetch a list of customers
            return em.createQuery("from Customer", Customer.class)
                    .getResultList();

        } finally {

            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public Set<Integer> getCustomerIds() {
        EntityManager em = emf.createEntityManager();
        try {

            // fetch a list of customers
             List<Integer> aux = em.createQuery("select id from Customer", Integer.class)
                    .getResultList();

            return new HashSet<Integer>(aux);


        } finally {

            if (em != null) {
                em.close();
            }
        }

    }

    @Override
    public double getBalance(int customerId) {
        EntityManager em = emf.createEntityManager();
        try {

            // fetch a list of customers
            Customer aux = findById(customerId);
            Double result = 0.0;
            List<Account> accountList = aux.getAccounts();

            for(int i= 0; i<accountList.size();i++){
                result+= accountList.get(i).getBalance();
            }
            return result;

        } finally {

            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public Set<Integer> getCustomerAccountNumbers(Integer id) {
        EntityManager em = emf.createEntityManager();
        try {

            Customer aux = findById(id);
            List<Account> accountList = aux.getAccounts();
            Set<Integer> result = new HashSet<>();

            for(int i= 0; i<accountList.size();i++){
                result.add(accountList.get(i).getId());
            }
            return result;

        } finally {

            if (em != null) {
                em.close();
            }
        }
    }
}
