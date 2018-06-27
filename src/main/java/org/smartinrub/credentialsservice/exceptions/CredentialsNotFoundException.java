package org.smartinrub.credentialsservice.exceptions;

public class CredentialsNotFoundException extends RuntimeException {

    public CredentialsNotFoundException(String email) {
        super("CredentialsNotFoundException with id=" + email);
    }
}
