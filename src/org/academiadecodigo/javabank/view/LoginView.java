package org.academiadecodigo.javabank.view;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerSetInputScanner;
import org.academiadecodigo.javabank.controller.LoginController;
import org.academiadecodigo.javabank.model.Bank;
import org.academiadecodigo.javabank.utils.Messages;

public class LoginView extends AbstractView{

    private LoginController loginController;

    public LoginView(Bank bank, Prompt prompt) {
        super(bank, prompt);
    }

    @Override
    public void show() {
        IntegerSetInputScanner scanner = new IntegerSetInputScanner(bank.getCustomerIds());
        scanner.setMessage(Messages.CHOOSE_CUSTOMER);
        scanner.setError(Messages.ERROR_INVALID_CUSTOMER);
        loginController.chooseCustomer(prompt.getUserInput(scanner));
    }

    public void setLoginController(LoginController loginController) {
        this.loginController = loginController;
    }
}
