package user.userdelete.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import user.userdelete.model.User;

@Repository
public interface UserJpaRepo extends MongoRepository<User, String> {

    void deleteUserByUsername(String s);
}
