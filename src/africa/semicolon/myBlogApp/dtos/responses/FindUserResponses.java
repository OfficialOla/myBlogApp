package africa.semicolon.myBlogApp.dtos.responses;

import lombok.Data;

@Data
public class FindUserResponses {
    private String userId;
    private String username;
    private String fullName;
    private String dateRegistered;

}
