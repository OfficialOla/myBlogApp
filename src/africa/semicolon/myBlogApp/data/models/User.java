package africa.semicolon.myBlogApp.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document
public class User {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private LocalDateTime dateRegistered = LocalDateTime.now();
}