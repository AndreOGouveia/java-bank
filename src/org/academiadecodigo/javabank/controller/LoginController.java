package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.javabank.services.CustomerAuthenticationService;
import org.academiadecodigo.javabank.services.CustomerService;

public class LoginController extends AbstractController {

    private Controller nextController;
    private CustomerAuthenticationService customerAuthenticationService;

    private CustomerService customerService;

    public void onLogin(int id) {
        if(customerAuthenticationService.authenticate(id)) {
            customerService.setLoginCustomer(id);
            nextController.init();

        } else{

            this.init();
        }
    }

    public void setNextController(Controller nextController) {
        this.nextController = nextController;
    }

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    public void setCustomerAuthenticationService(CustomerAuthenticationService customerAuthenticationService) {
        this.customerAuthenticationService = customerAuthenticationService;
    }
}
