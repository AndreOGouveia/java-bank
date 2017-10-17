package org.academiadecodigo.javabank.persistence.dao.jpa;

import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.persistence.JpaSessionManager;
import org.academiadecodigo.javabank.persistence.dao.DaoAccount;



public class JpaDaoAccount extends JpaGenericDao<Account> implements DaoAccount{


    public JpaDaoAccount(JpaSessionManager sm) {
        super(sm, Account.class);

    }
}