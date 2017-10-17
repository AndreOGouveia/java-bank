package org.academiadecodigo.javabank.persistence.dao.jpa;

import org.academiadecodigo.javabank.model.AbstractModel;
import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.persistence.JpaSessionManager;
import org.academiadecodigo.javabank.persistence.dao.DaoCustomer;


import java.util.Set;

public class JpaDaoCustomer extends JpaGenericDao<Customer> implements DaoCustomer{

    public JpaDaoCustomer(JpaSessionManager sm) {
        super(sm, Customer.class);
    }

    @Override
    public Set<Integer> getCustomerAccountIds(Integer id) {
        return null;
    }
}
