package org.academiadecodigo.javabank.view;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.javabank.services.CustomerService;

public abstract class AbstractView implements View{

    protected CustomerService customerService;
    protected Prompt prompt;

    public AbstractView(CustomerService customerService, Prompt prompt) {
        this.customerService = customerService;
        this.prompt = prompt;
    }


}
