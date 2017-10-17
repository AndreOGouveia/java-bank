package org.academiadecodigo.javabank.persistence;

// allows services to use common semantics for read/write operations
public class JpaTransactionManager implements TransactionManager {


    JpaSessionManager sm;

    public JpaTransactionManager(JpaSessionManager sm) {
        this.sm = sm;
    }

    @Override
    public void beginRead() {
        sm.startSession();
    }

    @Override
    public void beginWrite() {
        sm.getCurrentSession().getTransaction().begin();
    }

    @Override
    public void commit() {

        if (sm.getCurrentSession().getTransaction().isActive()) {
            sm.getCurrentSession().getTransaction().commit();
        }

        sm.stopSession();
    }

    @Override
    public void rollback() {

        if (sm.getCurrentSession().getTransaction().isActive()) {
            sm.getCurrentSession().getTransaction().rollback();
        }

        sm.stopSession();
    }
}
