package africa.semicolon.myBlogApp.data.repositories;

import africa.semicolon.myBlogApp.data.models.Article;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ArticleRepository extends MongoRepository<Article, String> {

}
