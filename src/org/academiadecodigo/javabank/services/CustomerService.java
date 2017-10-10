package org.academiadecodigo.javabank.services;

import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.model.account.Account;

import java.util.HashMap;
import java.util.Set;

public class CustomerService {

    private HashMap<Integer, Customer> customers;
    private AuthenticationService authenticationService;


    public CustomerService() {
        this.customers = new HashMap<>();
    }

    public void addCustomer(Customer customer) {
        customers.put(customer.getId(), customer);
    }

    public Set<Integer> getCustomerIds() {
        return customers.keySet();
    }

    public Customer getCustomer(int id){
        return customers.get(id);
    }

    public void setAuthenticationService(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    public void addAccount(Account account){
        authenticationService.getLoginCustomer().getAccounts().put(account.getId(),account);
    }

    public Customer getLoginCustomer(){
        return authenticationService.getLoginCustomer();
    }


}
