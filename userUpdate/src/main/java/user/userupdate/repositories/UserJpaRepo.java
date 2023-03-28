package user.userupdate.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import user.userupdate.model.User;

@Repository
public interface UserJpaRepo extends MongoRepository<User, String> {

    User findUserByUsername(String s);

    User findUserByEmail(String s);
}
