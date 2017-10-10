package org.academiadecodigo.javabank.view;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.javabank.application.UserOptions;
import org.academiadecodigo.javabank.controller.MenuController;
import org.academiadecodigo.javabank.model.Bank;
import org.academiadecodigo.javabank.utils.Messages;

public class MenuView extends AbstractView {

    MenuController menuController;


    public MenuView(Bank bank, Prompt prompt) {
        super(bank, prompt);
    }

    @Override
    public void show() {

        MenuInputScanner mainMenu = new MenuInputScanner(UserOptions.getMessages());
        mainMenu.setError(Messages.ERROR_INVALID_OPTION);
        mainMenu.setMessage(Messages.MENU_WELCOME);

        int choice = prompt.getUserInput(mainMenu);

        menuController.chosenOption(choice);
    }

    public void setMenuController(MenuController menuController) {
        this.menuController = menuController;
    }
}
