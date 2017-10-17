package org.academiadecodigo.javabank.persistence.dao;

import org.academiadecodigo.javabank.model.AbstractModel;
import org.academiadecodigo.javabank.model.Customer;

import java.util.Set;

public interface DaoCustomer extends DaoCRUD<Customer> {

    Set<Integer> getCustomerAccountIds(Integer id);
}
