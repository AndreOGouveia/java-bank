package org.academiadecodigo.javabank.persistence.dao;

import org.academiadecodigo.javabank.model.AbstractModel;
import org.academiadecodigo.javabank.persistence.TransactionException;

import java.util.List;

public interface DaoCRUD<T extends AbstractModel> {

    List<T> findAll();

    T findById(Integer id);

    T saveOrUpdate(T modelObject) throws TransactionException;

    void delete(Integer id) throws TransactionException;

}
