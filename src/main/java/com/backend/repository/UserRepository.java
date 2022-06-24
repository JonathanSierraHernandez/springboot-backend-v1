package com.backend.repository;

import com.backend.model.Usr;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<Usr, Long> {

    @Query("SELECT u FROM Usr u WHERE u.email = ?1")
    Usr findUserByStatus(String email);

}