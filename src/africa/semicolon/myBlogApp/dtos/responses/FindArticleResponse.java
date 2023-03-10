package africa.semicolon.myBlogApp.dtos.responses;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FindArticleResponse {
    private String id;
    private String title;
    private String body;
    private LocalDateTime timeCreated = LocalDateTime.now();
    private String authorId;
}
