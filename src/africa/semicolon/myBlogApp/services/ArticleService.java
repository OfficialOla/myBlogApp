package africa.semicolon.myBlogApp.services;

import africa.semicolon.myBlogApp.data.models.Article;
import africa.semicolon.myBlogApp.dtos.requests.CreateArticleRequest;
import africa.semicolon.myBlogApp.dtos.responses.FindArticleResponse;

import java.util.List;

public interface ArticleService {
    Object createNewArticle(CreateArticleRequest createArticleRequest);
    FindArticleResponse findArticle(String id);
    long count();

    List<Article> findAllArticle();
}