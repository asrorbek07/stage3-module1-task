package com.mjc.school.service.exception;

import java.io.Serial;

public class NotValidException extends RuntimeException {
    //
    @Serial
    private static final long serialVersionUID = 2L;

    public NotValidException(String message) {
        super(message);
    }
}
