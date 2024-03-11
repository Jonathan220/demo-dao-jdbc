package org.example.Exception;

public class DbIntegrityException extends RuntimeException{

    public DbIntegrityException(String message) {
        super(message);
    }
}
