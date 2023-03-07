package africa.semicolon.myBlogApp.dtos.requests;

import lombok.Data;

@Data
public class CreateArticleRequest {
    private String title;
    private String body;
    private String authorId;

}
