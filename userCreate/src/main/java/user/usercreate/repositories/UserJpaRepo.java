package user.usercreate.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import user.usercreate.model.User;

public interface UserJpaRepo extends MongoRepository<User, String> {

    User findUserByUsername(String s);
}
