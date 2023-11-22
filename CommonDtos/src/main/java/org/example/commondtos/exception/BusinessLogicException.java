package org.example.commondtos.exception;

import java.util.NoSuchElementException;

public class BusinessLogicException extends NoSuchElementException {

    public BusinessLogicException(String s) {
        super(s);
    }
}
