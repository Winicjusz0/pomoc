package com.company;

public class NoWinnerException extends RuntimeException {
    public NoWinnerException(String message) {
        super(message);
    }
}
// każdy wyjątek tworzy się w taki sposób