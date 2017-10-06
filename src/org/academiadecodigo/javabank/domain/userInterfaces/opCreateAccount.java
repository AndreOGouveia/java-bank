package org.academiadecodigo.javabank.domain.userInterfaces;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.javabank.domain.Customer;
import org.academiadecodigo.javabank.domain.accounts.AccountType;


public class opCreateAccount implements Operation {

    private Customer customer;
    private Prompt prompt;


    public opCreateAccount(Customer customer, Prompt prompt) {
        this.customer = customer;
        this.prompt = prompt;
    }

    private int showMenu() {
        String[] options = {"Savings Account", "Checking Account", "Back"};

// Create a new prompt attached to standard input/output
        Prompt prompt = new Prompt(System.in, System.out);

// Instantiate a menu scanner
        MenuInputScanner scanner = new MenuInputScanner(options);

// Setup the menu prompt message
        scanner.setMessage("Choose an option: ");

// Grab the user in a loop until a valid input is inserted
        int selected = prompt.getUserInput(scanner);

        return selected;
    }


    @Override
    public void execute() {

        int type = showMenu();
        int newAccount = -1;
        switch(type){
            case 1:
                newAccount = customer.createAccount(AccountType.SAVINGS);
                break;
            case 2:
                newAccount = customer.createAccount(AccountType.CHECKING);
                break;
            case 3:
                return;
        }

        System.out.println("Created account number: "+ newAccount);


    }


}
