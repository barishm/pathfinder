package bg.softuni.pathfinder.service.impl;

import bg.softuni.pathfinder.exeptions.LoginCredentialsException;
import bg.softuni.pathfinder.exeptions.UserNotFoundException;
import bg.softuni.pathfinder.model.User;
import bg.softuni.pathfinder.model.dto.UserLoginDTO;
import bg.softuni.pathfinder.model.dto.UserProfileViewModel;
import bg.softuni.pathfinder.model.dto.UserRegisterDTO;
import bg.softuni.pathfinder.repository.UserRepository;
import bg.softuni.pathfinder.service.UserService;
import bg.softuni.pathfinder.service.session.LoggedUser;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private ModelMapper modelMapper;
    private PasswordEncoder passwordEncoder;
    private LoggedUser loggedUser;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder, LoggedUser loggedUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.loggedUser = loggedUser;
    }

    public List<User> getUser() {
        return null;
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    public void save(UserRegisterDTO userRegisterDTO) {
        User user = modelMapper.map(userRegisterDTO,User.class);
        user.setPassword(passwordEncoder.encode(userRegisterDTO.getPassword()));
        userRepository.save(user);
    }

    @Override
    public boolean login(UserLoginDTO userLoginDTO) throws LoginCredentialsException {
        User user = this.userRepository.findByUsername(userLoginDTO.getUsername()).orElseThrow(() -> new LoginCredentialsException("User not found!"));
        if(user == null){
            throw new LoginCredentialsException("User with that username is not present");
        }
        boolean passwordMatch = passwordEncoder.matches(userLoginDTO.getPassword(), user.getPassword());
        if(!passwordMatch) {
            throw new LoginCredentialsException("User entered incorrect password");
        }

        loggedUser.setUsername(user.getUsername());
        loggedUser.setEmail(user.getEmail());
        loggedUser.setFullName(user.getFullName());
        loggedUser.setLogged(true);
        return passwordMatch;
    }

    @Override
    public void logout() {
        loggedUser.reset();
    }

    @Override
    public User getLoggedUser() {
        return userRepository.findByUsername(loggedUser.getUsername()).orElseThrow(() -> new UserNotFoundException("User not found!"));
    }

    @Override
    public UserProfileViewModel getUserProfile() {
        User user = userRepository.findByUsername(loggedUser.getUsername()).orElseThrow(() -> new UserNotFoundException("User not found!"));
        return modelMapper.map(user, UserProfileViewModel.class);
    }

}
