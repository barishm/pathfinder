package bg.softuni.pathfinder.service;

import bg.softuni.pathfinder.model.User;
import bg.softuni.pathfinder.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUser() {
        return null;
    }
}
