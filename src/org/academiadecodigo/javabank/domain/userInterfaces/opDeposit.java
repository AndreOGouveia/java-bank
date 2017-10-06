package org.academiadecodigo.javabank.domain.userInterfaces;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.javabank.domain.Customer;

public class opDeposit implements Operation {

    private Customer customer;
    private Prompt prompt;

    public opDeposit(Customer customer, Prompt prompt) {
        this.customer = customer;
        this.prompt= prompt;

    }

    @Override
    public void execute() {


        



    }
}
