package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.javabank.services.CustomerService;

public abstract class AbstractController implements Controller {

    protected CustomerService customerService;
    protected Controller nextController;


    public AbstractController(CustomerService customerService) {
        this.customerService = customerService;
    }

    public void setNextController(Controller nextController) {
        this.nextController = nextController;
    }

}
