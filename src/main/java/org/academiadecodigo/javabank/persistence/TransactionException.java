package org.academiadecodigo.javabank.persistence;

public class TransactionException extends RuntimeException{
    public TransactionException() {
    }

    public TransactionException(String s) {
        super(s);
    }
}
