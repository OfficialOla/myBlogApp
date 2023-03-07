package africa.semicolon.myBlogApp.data.repositories;

import africa.semicolon.myBlogApp.data.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

    User findByUserName(String userName);
}
