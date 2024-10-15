package com.gabrielcacarvalho.mater_imperium_test.repository;

import com.gabrielcacarvalho.mater_imperium_test.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    Optional<User> findByUsername(String email);
}