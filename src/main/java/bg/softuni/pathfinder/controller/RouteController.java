package bg.softuni.pathfinder.controller;

import bg.softuni.pathfinder.model.Category;
import bg.softuni.pathfinder.model.CategoryNames;
import bg.softuni.pathfinder.model.Level;
import bg.softuni.pathfinder.model.dto.AddRouteDTO;
import bg.softuni.pathfinder.service.RouteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/routes")
public class RouteController {
    private final RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping("/add")
    public ModelAndView addRoute() {
        ModelAndView modelAndView = new ModelAndView("add-route");
        modelAndView.addObject("levels",Level.getEnumsAsList());
        modelAndView.addObject("categories", CategoryNames.values());
        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView addRoute(AddRouteDTO addRouteDTO) {
        routeService.add(addRouteDTO);
        return new ModelAndView("redirect:/");
    }



}
