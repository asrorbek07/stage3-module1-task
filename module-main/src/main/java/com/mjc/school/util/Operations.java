package com.mjc.school.util;

public enum Operations {
    GET_ALL_NEWS(1, "Get all news."),
    GET_NEWS_BY_ID(2, "Get news by id."),
    CREATE_NEWS(3, "Create news."),
    UPDATE_NEWS(4, "Update news."),
    REMOVE_NEWS_BY_ID(5, "Remove news by id."),
    EXIT(0, "Exit.");

    private final Integer operationNumber;
    private final String operation;

    private Operations(Integer operationNumber, String operation) {
        this.operationNumber = operationNumber;
        this.operation = operation;
    }

    public String getOperation() {
        return "Operation: " + this.operation;
    }

    public String getOperationWithNumber() {
        return this.operationNumber + " - " + this.operation;
    }
}
