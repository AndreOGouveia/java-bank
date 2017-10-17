package org.academiadecodigo.javabank;

import org.academiadecodigo.javabank.controller.Controller;
import org.academiadecodigo.javabank.persistence.H2WebServer;
import org.academiadecodigo.javabank.persistence.JpaSessionManager;
import org.academiadecodigo.javabank.persistence.JpaTransactionManager;
import org.academiadecodigo.javabank.persistence.TransactionManager;
import org.academiadecodigo.javabank.persistence.dao.DaoAccount;
import org.academiadecodigo.javabank.persistence.dao.DaoCustomer;
import org.academiadecodigo.javabank.persistence.dao.jpa.JpaDaoAccount;
import org.academiadecodigo.javabank.persistence.dao.jpa.JpaDaoCustomer;
import org.academiadecodigo.javabank.services.jpa.AccountServiceImpl;
import org.academiadecodigo.javabank.services.jpa.CustomerServiceImpl;
import org.academiadecodigo.javabank.services.AuthServiceImpl;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.SQLException;

public class App {

    public static void main(String[] args) {

        try {


            H2WebServer h2WebServer = new H2WebServer();
            h2WebServer.start();

            EntityManagerFactory emf = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT);

            App app = new App();
            app.bootStrap(emf);

            emf.close();
            h2WebServer.stop();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void bootStrap(EntityManagerFactory emf) {

        Bootstrap bootstrap = new Bootstrap();

        JpaSessionManager sm = new JpaSessionManager(emf);
        TransactionManager tm = new JpaTransactionManager(sm);



        bootstrap.setAuthService(new AuthServiceImpl());
        bootstrap.setAccountService(new AccountServiceImpl(tm,new JpaDaoAccount(sm)));
        bootstrap.setCustomerService(new CustomerServiceImpl(tm,new JpaDaoCustomer(sm)));

        Controller controller = bootstrap.wireObjects();

        // start application
        controller.init();

    }
}
