package org.academiadecodigo.javabank.view;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerSetInputScanner;
import org.academiadecodigo.javabank.controller.LoginController;
import org.academiadecodigo.javabank.services.CustomerService;
import org.academiadecodigo.javabank.utils.Messages;

public class LoginView extends AbstractView{

    private LoginController loginController;

    public LoginView(CustomerService customerService, Prompt prompt) {
        super(customerService, prompt);
    }

    @Override
    public void show() {
        IntegerSetInputScanner scanner = new IntegerSetInputScanner(customerService.getCustomerIds());
        scanner.setMessage(Messages.CHOOSE_CUSTOMER);
        scanner.setError(Messages.ERROR_INVALID_CUSTOMER);
        loginController.chooseCustomer(prompt.getUserInput(scanner));
    }

    public void setLoginController(LoginController loginController) {
        this.loginController = loginController;
    }
}
