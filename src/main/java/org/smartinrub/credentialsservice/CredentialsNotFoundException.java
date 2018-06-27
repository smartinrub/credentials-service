package org.smartinrub.credentialsservice;

public class CredentialsNotFoundException extends RuntimeException {

    public CredentialsNotFoundException(String email) {
        super("CredentialsNotFoundException with id=" + email);
    }
}
