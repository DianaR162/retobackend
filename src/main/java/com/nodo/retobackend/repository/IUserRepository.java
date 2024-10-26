package com.nodo.retobackend.repository;

import com.nodo.retobackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, String> {
    Optional<User> findByMailAndPassword(String mail, String password);
}
