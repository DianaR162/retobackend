package com.nodo.retobackend.exception;

import lombok.Getter;

@Getter
public class CoreException extends Exception {
    private final String userMessage;
    private final Integer status;

    public CoreException(String userMessage, Integer status, Throwable e) {
        super(userMessage, e);
        this.userMessage = userMessage;
        this.status = status;
    }

    public CoreException(String userMessage, Integer status) {
        super(userMessage);
        this.userMessage = userMessage;
        this.status = status;
    }
}
