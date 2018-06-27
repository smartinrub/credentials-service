package org.smartinrub.credentialsservice.grpc;

        import io.grpc.stub.StreamObserver;
        import org.lognet.springboot.grpc.GRpcService;
        import org.slf4j.Logger;
        import org.slf4j.LoggerFactory;
        import org.smartinrub.credentialsservice.BCrypt;
        import org.smartinrub.credentialsservice.BCryptServiceGrpc;

@GRpcService
public class BCryptService extends BCryptServiceGrpc.BCryptServiceImplBase {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(BCryptService.class);


    @Override
    public void checkHashedPassword(BCrypt.PasswordRequest request,
                                    StreamObserver<BCrypt.BCryptResponse> responseObserver) {
        LOGGER.info("server received {}", request);
        final BCrypt.BCryptResponse.Builder passwordResponse =
                BCrypt.BCryptResponse.newBuilder().setMessage(request.getPassword());
        responseObserver.onNext(passwordResponse.build());
        responseObserver.onCompleted();
        LOGGER.info("server responded {}", passwordResponse);
    }
}
