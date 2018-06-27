package org.smartinrub.credentialsservice.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smartinrub.credentialsservice.BCrypt;
import org.smartinrub.credentialsservice.BCryptServiceGrpc;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class BCryptClient {
    private static final Logger LOGGER =
            LoggerFactory.getLogger(BCryptClient.class);

    private BCryptServiceGrpc.BCryptServiceBlockingStub bCryptServiceBlockingStub;

    @PostConstruct
    private void init() {
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 6565).usePlaintext().build();

        bCryptServiceBlockingStub = BCryptServiceGrpc.newBlockingStub(managedChannel);
    }

    public String checkHashedPassword(String password) {
        BCrypt.PasswordRequest passwordRequest = BCrypt.PasswordRequest.newBuilder().setPassword(password).build();
        LOGGER.info("client sending {}", passwordRequest);

        BCrypt.BCryptResponse bCryptResponse = bCryptServiceBlockingStub.checkHashedPassword(passwordRequest);
        LOGGER.info("client received {}", bCryptResponse);

        return bCryptResponse.getMessage();
    }

}
