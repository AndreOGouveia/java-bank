package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.javabank.services.JPACustomerServiceImpl;
import org.academiadecodigo.model.Customer;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.swing.text.html.parser.Entity;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.TestCase.assertEquals;

public class JPACustomerServiceImplTest extends TestPersistanceHelper{


    JPACustomerServiceImpl jpaCustomerService;

    @Before
    public void setup2(){
        jpaCustomerService = new JPACustomerServiceImpl(emf);
    }



    @Test
    public void addTest(){
        Customer newCustomer = new Customer();
        newCustomer.setName("Manuel");
        Customer savedCustomer = jpaCustomerService.add(newCustomer);

        Customer foundCustomer = em.find(Customer.class,4) ;

        assertNotNull("shoul not be null",foundCustomer);

    }

    @Test
    public void findByIdTest(){
        Customer aux = jpaCustomerService.findById(1);
        String expected = "André";
        assertEquals(expected,aux.getName());

    }

    @Test
    public void findAllTest(){
        List<Customer> list = jpaCustomerService.findAll();
        int expected = 3;
        assertEquals(expected,list.size());


    }

    @Test
    public void getCustomerIdsTest(){
        Set<Integer> aux = new HashSet<>();
        aux.add(1);
        aux.add(2);
        aux.add(3);

        Set<Integer> ids = jpaCustomerService.getCustomerIds();

        assertEquals(aux,ids);

    }

    @Test
    public void getBalanceTest(){

        Double result = jpaCustomerService.getBalance(1);
        Double expected = 370.0;

        assertEquals("result="+result,result,expected);

    }

    @Test
    public void getCustomerAccountNumbersTest(){

        Set<Integer>  result = jpaCustomerService.getCustomerAccountNumbers(1);
        Set<Integer> aux = new HashSet<>();
        aux.add(1);
        aux.add(5);
        aux.add(3);

        assertEquals(result,aux);

    }



}
