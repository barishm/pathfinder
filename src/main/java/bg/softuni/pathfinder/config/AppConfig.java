package bg.softuni.pathfinder.config;

import bg.softuni.pathfinder.model.Level;
import bg.softuni.pathfinder.model.User;
import bg.softuni.pathfinder.service.RoleService;
import org.modelmapper.ModelMapper;
import org.modelmapper.Provider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@Configuration
public class AppConfig {
    private final RoleService roleService;

    public AppConfig(RoleService roleService) {
        this.roleService = roleService;
    }

    @Bean
    public ModelMapper modelMapper(){

        Provider<User> newUserProvider = req -> new User()
                .setRoles(Set.of(roleService.getRoleByName("USER")))
                .setLevel(Level.BEGINNER);



        return new ModelMapper();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
