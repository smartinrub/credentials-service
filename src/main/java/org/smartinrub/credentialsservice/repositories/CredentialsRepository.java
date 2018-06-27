package org.smartinrub.credentialsservice.repositories;

import org.smartinrub.credentialsservice.models.Credentials;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CredentialsRepository extends CrudRepository<Credentials, Long> {

    @Query("SELECT u FROM Credentials u WHERE u.email = ?1")
    Optional<Credentials> findByEmail(String email);
}
