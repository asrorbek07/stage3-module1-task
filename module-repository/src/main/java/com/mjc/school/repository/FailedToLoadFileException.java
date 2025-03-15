package com.mjc.school.repository;

import java.io.Serial;

public class FailedToLoadFileException extends RuntimeException {
    //
    @Serial
    private static final long serialVersionUID = 1L;

    public FailedToLoadFileException(String message) {
        super(message);
    }
}
