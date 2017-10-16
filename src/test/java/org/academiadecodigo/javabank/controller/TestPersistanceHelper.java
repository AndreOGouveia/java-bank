package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.javabank.Config;
import org.academiadecodigo.javabank.persistence.H2WebServer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.SQLException;

public class TestPersistanceHelper {

    protected EntityManagerFactory emf;
    protected EntityManager em;

    @Before
    public  void setup(){

        emf = Persistence.createEntityManagerFactory(Config.PERSISTENT);
        em=emf.createEntityManager();
    }


    @After
    public  void bdStop(){
        em.close();
        emf.close();
    }
}
