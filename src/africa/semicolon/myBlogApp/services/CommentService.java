package africa.semicolon.myBlogApp.services;

import africa.semicolon.myBlogApp.data.models.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentService extends MongoRepository<Comment, String> {
}
