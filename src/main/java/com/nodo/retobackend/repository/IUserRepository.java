package com.nodo.retobackend.repository;

import com.nodo.retobackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, String> {
  Optional<User> findByMail(String mail);
}
