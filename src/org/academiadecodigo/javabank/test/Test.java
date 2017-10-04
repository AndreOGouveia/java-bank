package org.academiadecodigo.javabank.test;

public class Test {

    public static void main(String[] args) {

        SavingsAccountTest savingsAccountTest = new SavingsAccountTest();

        CheckingAccountTest checkingAccountTest = new CheckingAccountTest();
        AccountManagerTest accountManagerTest = new AccountManagerTest();

     //   CustomerTest customerTest = new CustomerTest();



     //   BankTest bankTest = new BankTest();


        System.out.println("Savings Account: " + (savingsAccountTest.test() ? "OK" : "FAIL"));
        System.out.println("Checking Account: " + (checkingAccountTest.test() ? "OK" : "FAIL"));
        System.out.println("Account Manager " + (accountManagerTest.test() ? "OK" : "FAIL"));
      //  System.out.println("Customer: " + (customerTest.test() ? "OK" : "FAIL"));

      //  System.out.println("Bank: " + (bankTest.test() ? "OK" : "FAIL"));
    }


}
