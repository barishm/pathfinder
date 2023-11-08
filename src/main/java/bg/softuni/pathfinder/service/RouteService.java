package bg.softuni.pathfinder.service;

import bg.softuni.pathfinder.model.Route;
import bg.softuni.pathfinder.model.dto.AddRouteDTO;
import bg.softuni.pathfinder.model.dto.RouteGetAllViewModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RouteService {
    void add(AddRouteDTO addRouteDTO);

    List<RouteGetAllViewModel> getAll();
}
