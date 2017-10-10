package org.academiadecodigo.javabank.services;

public class CustomerAuthenticationService {

    private CustomerService customerService;


    public boolean authenticate(int customerId){

       return customerService.getCustomerIds().contains(customerId);

    }

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }
}
