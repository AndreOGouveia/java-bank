package org.academiadecodigo.javabank.view;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.javabank.controller.OpenAccountController;
import org.academiadecodigo.javabank.model.Bank;
import org.academiadecodigo.javabank.model.account.AccountType;
import org.academiadecodigo.javabank.utils.Messages;

public class OpenAccountView extends AbstractView{

    OpenAccountController openAccountController;

    public OpenAccountView(Bank bank, Prompt prompt) {
        super(bank, prompt);
    }

    @Override
    public void show() {

        String[] accountTypes = new String[AccountType.values().length];
        for(int i=0 ; i<AccountType.values().length;i++){
            accountTypes[i]= AccountType.values()[i].toString();
        }

        MenuInputScanner mainMenu = new MenuInputScanner(accountTypes);
        mainMenu.setError(Messages.ERROR_INVALID_OPTION);
        mainMenu.setMessage(Messages.MENU_OPEN_ACCOUNT);

        openAccountController.openAccountType(prompt.getUserInput(mainMenu));

    }

    public void setOpenAccountController(OpenAccountController openAccountController) {
        this.openAccountController = openAccountController;
    }
}
