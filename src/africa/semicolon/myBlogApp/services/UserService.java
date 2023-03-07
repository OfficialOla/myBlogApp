package africa.semicolon.myBlogApp.services;

import africa.semicolon.myBlogApp.data.models.User;
import africa.semicolon.myBlogApp.dtos.requests.RegisterRequest;
import africa.semicolon.myBlogApp.dtos.responses.FindUserResponses;

public interface UserService {
    User register(RegisterRequest request);
    FindUserResponses findUser(String id);
    //    List<FindUserResponse> findAll();
    void delete(User user);
    void delete(String id);
//    void deleteAll();
//
//    FindUserResponse findByUsername();
//    User findId(int id);
}

