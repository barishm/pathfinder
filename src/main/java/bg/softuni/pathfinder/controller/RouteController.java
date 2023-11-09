package bg.softuni.pathfinder.controller;

import bg.softuni.pathfinder.model.CategoryNames;
import bg.softuni.pathfinder.model.Level;
import bg.softuni.pathfinder.model.Route;
import bg.softuni.pathfinder.model.dto.AddRouteDTO;
import bg.softuni.pathfinder.model.dto.RouteDetailsViewModel;
import bg.softuni.pathfinder.model.dto.RouteViewModel;
import bg.softuni.pathfinder.service.RouteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/routes")
public class RouteController {
    @Value("${binding-result-package}")
    private String bindingResultPath;

    private static final String DOT = ".";

    private final RouteService routeService;


    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping
    public ModelAndView routes() {
        List<RouteViewModel> routeViewModel = routeService.getAll();
        ModelAndView modelAndView = new ModelAndView("routes");
        modelAndView.addObject("routes", routeViewModel);
        return modelAndView;
    }

    @GetMapping("/details/{id}")
    public ModelAndView getAll(@PathVariable("id") Long id){
        RouteDetailsViewModel route = routeService.getDetails(id);
        ModelAndView modelAndView = new ModelAndView("route-details");
        modelAndView.addObject("route", route);
        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView addRoute() {
        ModelAndView modelAndView = new ModelAndView("add-route");
        modelAndView.addObject("levels",Level.getEnumsAsList());
        modelAndView.addObject("categories", CategoryNames.values());
        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView addRoute(@Valid AddRouteDTO addRouteDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        ModelAndView modelAndView = new ModelAndView();
        if(bindingResult.hasErrors()){
            final String attributeName = "addRouteDTO";
            redirectAttributes.addFlashAttribute(attributeName,addRouteDTO).addFlashAttribute(bindingResultPath + DOT + attributeName,bindingResult);
            modelAndView.setViewName("redirect:/add");
        }else {
            routeService.add(addRouteDTO);
            modelAndView.setViewName("redirect:/routes");
        }

        return modelAndView;
    }



}
