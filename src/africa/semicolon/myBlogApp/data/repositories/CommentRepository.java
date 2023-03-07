package africa.semicolon.myBlogApp.data.repositories;

import africa.semicolon.myBlogApp.data.models.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentRepository extends MongoRepository<Comment, String> {

}
