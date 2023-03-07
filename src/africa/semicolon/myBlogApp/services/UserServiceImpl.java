package africa.semicolon.myBlogApp.services;

import africa.semicolon.myBlogApp.data.models.User;
import africa.semicolon.myBlogApp.data.repositories.UserRepository;
import africa.semicolon.myBlogApp.dtos.requests.RegisterRequest;
import africa.semicolon.myBlogApp.dtos.responses.FindUserResponses;
import africa.semicolon.myBlogApp.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
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
        return found != null;
    }

    @Override
    public FindUserResponses findUser(String id) {
        Optional<User> foundUser = userRepository.findById(id);
        System.out.println(foundUser);
        if (foundUser.isEmpty() ) throw new NullPointerException("User does not exist");
        FindUserResponses response = new FindUserResponses();
        Mapper.map(foundUser.get(), response);
        return response;
    }


    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public void delete(String id) {

    }
}
