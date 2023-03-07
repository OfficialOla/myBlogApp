package africa.semicolon.myBlogApp.services;

import africa.semicolon.myBlogApp.data.models.Article;
import africa.semicolon.myBlogApp.data.repositories.ArticleRepository;
import africa.semicolon.myBlogApp.dtos.requests.CreateArticleRequest;
import africa.semicolon.myBlogApp.dtos.responses.FindArticleResponse;
import africa.semicolon.myBlogApp.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleServiceImpl implements  ArticleService{
    @Autowired
    ArticleRepository articleRepository;
    @Autowired
    UserService userService;

    @Override
    public Object createNewArticle(CreateArticleRequest createArticleRequest) {
        checkAuthorExistsFrom(createArticleRequest);
        Article article = new Article();
        Mapper.map(createArticleRequest, article);
        return articleRepository.save(article);
    }
    private void checkAuthorExistsFrom(CreateArticleRequest createArticleRequest) {
        try {
         userService.findUser(createArticleRequest.getAuthorId());
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException(String.format("Author with id %s does not exist",
                    createArticleRequest.getAuthorId()));
        }
    }

    @Override
    public FindArticleResponse findArticle(String id) {
        Optional<Article> foundArticle = articleRepository.findById(id);
        if (foundArticle.isEmpty() ) throw new NullPointerException("User does not exist");
        FindArticleResponse response = new FindArticleResponse();
        Mapper.map(foundArticle.get(), response);
        return response;
    }

    @Override
    public long count() {
        return articleRepository.count();
    }

    @Override
    public List<Article> findAllArticle() {
//        List<Article> foundArticle = articleRepository.findAll();
//        FindArticleResponse response = new FindArticleResponse();
        return articleRepository.findAll();
    }

    private void convert(CreateArticleRequest createArticleRequest, Article article){
        article.setBody(createArticleRequest.getBody());
        article.setTitle(createArticleRequest.getTitle());
        article.setAuthorId(createArticleRequest.getAuthorId());
    }
}
