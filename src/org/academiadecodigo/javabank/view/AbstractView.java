package org.academiadecodigo.javabank.view;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.javabank.model.Bank;

public abstract class AbstractView implements View{

    protected Bank bank;
    protected Prompt prompt;

    public AbstractView(Bank bank, Prompt prompt) {
        this.bank = bank;
        this.prompt = prompt;
    }


}
