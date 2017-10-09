package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.javabank.model.Bank;

public abstract class AbstractController implements Controller {

    protected Bank bank;
    protected Controller nextController;


    public AbstractController(Bank bank) {
        this.bank = bank;
    }

    public void setNextController(Controller nextController) {
        this.nextController = nextController;
    }

}
