package bg.softuni.pathfinder.service;

import bg.softuni.pathfinder.model.dto.AddRouteDTO;
import bg.softuni.pathfinder.model.dto.RouteDetailsViewModel;
import bg.softuni.pathfinder.model.dto.RouteViewModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RouteService {
    void add(AddRouteDTO addRouteDTO);

    List<RouteViewModel> getAll();

    RouteDetailsViewModel getDetails(Long id);
}
