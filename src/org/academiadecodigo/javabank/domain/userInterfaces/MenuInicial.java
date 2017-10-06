package org.academiadecodigo.javabank.domain.userInterfaces;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.javabank.domain.Customer;

import java.util.Map;

public class MenuInicial {

    private Map<Integer,Operation> operations;
    private Operation operation;
    private Customer customer;
    private Prompt prompt;


    public MenuInicial(Customer customer, Prompt prompt){
        this.prompt = prompt;
        this.customer = customer;

        operations.put(1,new opDeposit(customer,prompt));
        operations.put(2,new opWithdraw(customer,prompt));
        operations.put(3,new opAccounts(customer,prompt));
        operations.put(4,new opCreateAccount(customer,prompt));
        operations.put(5,new opTransfer(customer,prompt));
        operations.put(6,new opExit());

    }

    public void start() {

        String[] options = {"Deposit", "Withdraw", "Accounts", "Create Account", "Transfer", "Exit"};

// Instantiate a menu scanner
        MenuInputScanner scanner = new MenuInputScanner(options);

// Setup the menu prompt message
        scanner.setMessage("Choose an option: ");

// Grab the user in a loop until a valid input is inserted
        int selected = prompt.getUserInput(scanner);

        operation = operations.get(selected);

    }



    public void chooseOperation(int selected){

            operation =
        switch(selected) {

            case 1:
                operation = new opDeposit();
                break;
            case 2:
                operation = new opWithdraw();
                break;
            case 3:
                operation = new opAccounts();
                break;
            case 4:
                operation = new opCreateAccount(customer,prompt);
                break;
            case 5:
                operation = new opTransfer();
                break;
            case 6:
                operation = new opExit();
                break;
            default:
                System.out.println("Invalid Operation!");
                operation = new opExit();
                break;


        }
    }


    }

