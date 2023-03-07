package africa.semicolon.myBlogApp.controller;

import africa.semicolon.myBlogApp.dtos.requests.CreateArticleRequest;
import africa.semicolon.myBlogApp.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ArticleController {
    @Autowired
    private ArticleService articleService;

@PostMapping("/article/createPost")
    public ResponseEntity<?> createPost(@RequestBody CreateArticleRequest request) {
    try {
        return new ResponseEntity<>(articleService.createNewArticle(request), HttpStatus.CREATED);
    } catch (NullPointerException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
    }
}
//    public  Object createPost(@RequestBody CreateArticleRequest createArticleRequest){
//    return articleService.createNewArticle(createArticleRequest);
//}

    @GetMapping("/article/findPost/{id}")
    public ResponseEntity<?> findPost(@PathVariable String id) {
        try {
            return new ResponseEntity<>(articleService.findArticle(id), HttpStatus.FOUND);
        } catch (IllegalArgumentException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
        }
    }

    @GetMapping("/articles")
    public ResponseEntity<?> findAllPost(){
    try{
        return new ResponseEntity<>(articleService.findAllArticle(), HttpStatus.FOUND);
    } catch (IllegalArgumentException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
    }
    }
}
