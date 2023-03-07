package africa.semicolon.myBlogApp.services;

import africa.semicolon.myBlogApp.data.models.User;
import africa.semicolon.myBlogApp.data.repositories.UserRepository;
import africa.semicolon.myBlogApp.data.repositories.UserRepositoryImpl;
import africa.semicolon.myBlogApp.dtos.requests.RegisterRequest;
import africa.semicolon.myBlogApp.dtos.responses.FindUserResponses;
import africa.semicolon.myBlogApp.utils.Mapper;


public class UserServiceImpl implements UserService{
    private static UserRepository userRepository = new UserRepositoryImpl();
    @Override
    public User register(RegisterRequest registerRequest) {
        if (userExist(registerRequest.getUsername())) throw new IllegalArgumentException(registerRequest.getUsername() + "already exist");
        return userRepository.save(Mapper.map(registerRequest));
        //User user = new User();
        //Mapper.map(registerRequest, user);
        //return userRepository.save(user);
    }

    private boolean userExist(String userName) {
        User found = userRepository.findByUserName(userName);
        if (found != null) return true;
        return false;
    }

    @Override
    public FindUserResponses findUser(int id) {
        User foundUser = userRepository.findById(id);
        if (foundUser == null ) throw new NullPointerException("User does not exist");
        FindUserResponses response = new FindUserResponses();
        Mapper.map(foundUser, response);
        return response;
    }


    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public void delete(int id) {

    }
}
