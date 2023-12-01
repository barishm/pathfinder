package bg.softuni.pathfinder.controller;

import bg.softuni.pathfinder.exeptions.LoginCredentialsException;
import bg.softuni.pathfinder.model.User;
import bg.softuni.pathfinder.model.dto.UserLoginDTO;
import bg.softuni.pathfinder.model.dto.UserProfileViewModel;
import bg.softuni.pathfinder.model.dto.UserRegisterDTO;
import bg.softuni.pathfinder.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.PublicKey;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("login");
    }


    @PostMapping("/login")
    public ModelAndView login(UserLoginDTO userLoginDTO) {
        boolean isLogged = userService.login(userLoginDTO);
        return new ModelAndView("redirect:/");
    }
    @ExceptionHandler(LoginCredentialsException.class)
    public ModelAndView handleLoginCredentialsError(LoginCredentialsException e,
                                                    RedirectAttributes redirectAttributes) {

        redirectAttributes.addFlashAttribute("badCredentials", true);
        System.out.println(e.getMessage());
        return new ModelAndView("redirect:login");
    }

    @GetMapping("/register")
    public ModelAndView register() {
        return new ModelAndView("register");
    }

    @PostMapping("/register")
    public ModelAndView register(UserRegisterDTO userRegisterDTO) {
        userService.save(userRegisterDTO);
        return new ModelAndView("redirect:login");
    }

    @PostMapping("/logout")
    public ModelAndView logout(){
        userService.logout();
        return new ModelAndView("redirect:/");
    }

    @GetMapping("/profile")
    public ModelAndView profile() {
        UserProfileViewModel userProfileViewModel = userService.getUserProfile();
        ModelAndView modelAndView = new ModelAndView("profile");
        modelAndView.addObject("userProfileViewModel",userProfileViewModel);
        return modelAndView;
    }

}
