package africa.semicolon.myBlogApp.utils;

import africa.semicolon.myBlogApp.data.models.Article;
import africa.semicolon.myBlogApp.data.models.User;
import africa.semicolon.myBlogApp.dtos.requests.CreateArticleRequest;
import africa.semicolon.myBlogApp.dtos.requests.RegisterRequest;
import africa.semicolon.myBlogApp.dtos.responses.FindArticleResponse;
import africa.semicolon.myBlogApp.dtos.responses.FindUserResponses;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Mapper {
    public static User map(RegisterRequest registerRequest){
        User user = new User();
        user.setFirstName(registerRequest.getFirstName());
        user.setLastName(registerRequest.getLastName());
        user.setUserName(registerRequest.getUsername());
        user.setPassword(registerRequest.getPassword());
        return user;
    }
    public static void map(CreateArticleRequest createArticleRequest, Article article) {
        article.setBody(createArticleRequest.getBody());
        article.setTitle(createArticleRequest.getTitle());
        article.setAuthorId(createArticleRequest.getAuthorId());
    }
    public static void map(RegisterRequest registerRequest, User user){
        user.setFirstName(registerRequest.getFirstName());
        user.setLastName(registerRequest.getLastName());
        user.setUserName(registerRequest.getUsername());
        user.setPassword(registerRequest.getPassword());
    }

    public static void map(User foundUser, FindUserResponses response){
        response.setFullName(foundUser.getFirstName()+ " " + foundUser.getLastName());
        response.setUserId(foundUser.getId());
        response.setUsername(foundUser.getUserName());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E, dd/MM/yyyy, hh:mm a");
        response.setDateRegistered(formatter.format(foundUser.getDateRegistered()));
    }

    public static void map(Article article, FindArticleResponse response) {
        response.setId(article.getId());
        response.setTitle(article.getTitle());
        response.setBody(article.getBody());
        response.setAuthorId(article.getAuthorId());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E, dd/MM/yyyy, hh:mm a");
        response.setTimeCreated(LocalDateTime.parse(formatter.format(article.getTimeCreated())));

    }
}
