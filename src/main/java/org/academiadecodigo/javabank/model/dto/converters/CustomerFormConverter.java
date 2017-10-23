package org.academiadecodigo.javabank.model.dto.converters;


import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.model.dto.FormCustomer;

public class CustomerFormConverter {



    public Customer formToCustomer(FormCustomer formCustomer , Customer customer){

        customer.setFirstName(formCustomer.getFirstName());
        customer.setLastName(formCustomer.getLastName());
        customer.setEmail(formCustomer.getEmail());
        customer.setPhone(formCustomer.getPhone());
        return customer;
    }

    public FormCustomer CustomerToForm(Customer customer, FormCustomer formCustomer){

        formCustomer.setFirstName(customer.getFirstName());
        formCustomer.setLastName(customer.getLastName());
        formCustomer.setEmail(customer.getEmail());
        formCustomer.setPhone(customer.getPhone());
        formCustomer.setId(customer.getId());

        return formCustomer;
    }


}
