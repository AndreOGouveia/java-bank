package org.academiadecodigo.javabank.services;

import org.academiadecodigo.javabank.model.Customer;

public class AuthenticationService {

    private CustomerService customerService;
    private int loginCustomer;
    public Customer getLoginCustomer() {
        return customerService.getCustomer(loginCustomer);
    }

    public boolean authenticate(int customerId){

       return customerService.getCustomerIds().contains(customerId);

    }

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    public void setLoginCustomer(int loginCustomer) {
        this.loginCustomer = loginCustomer;
    }
}
