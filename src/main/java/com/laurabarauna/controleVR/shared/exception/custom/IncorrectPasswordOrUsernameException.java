package com.laurabarauna.controleVR.shared.exception.custom;

public class IncorrectPasswordOrUsernameException extends RuntimeException {
    public IncorrectPasswordOrUsernameException(String message) {
        super(message);
    }
}
