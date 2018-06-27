package org.smartinrub.credentialsservice;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CredentialsRepository extends CrudRepository<Credentials, Long> {

    @Query("SELECT u FROM Credentials u WHERE u.email = ?1")
    Optional<Credentials> findByEmail(String email);
}
