package africa.semicolon.myBlogApp.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document
public class Article {
    @Id
    private String id;
    private String title;
    private String body;
    private LocalDateTime timeCreated = LocalDateTime.now();
    private String authorId;

}
