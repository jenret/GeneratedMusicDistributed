package io.swagger.repositories;

import io.swagger.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserJpaRepository extends MongoRepository<User, String> {
    User findUserByUsername(String s);

    User findUserByEmail(String s);
}
