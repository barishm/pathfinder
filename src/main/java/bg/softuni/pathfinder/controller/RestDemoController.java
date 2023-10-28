package bg.softuni.pathfinder.controller;


import bg.softuni.pathfinder.model.dto.UserRegisterDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/users")
public class RestDemoController {
    @GetMapping
    public ModelAndView login (){
        return new ModelAndView("login");
    }

    public ModelAndView register () {
        return new ModelAndView("register");
    }

    @PostMapping
    public ModelAndView register (UserRegisterDTO userRegisterDTO) {

        return new ModelAndView();
    }
}
