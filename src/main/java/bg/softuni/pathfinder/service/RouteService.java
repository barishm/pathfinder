package bg.softuni.pathfinder.service;

import bg.softuni.pathfinder.model.dto.AddRouteDTO;
import org.springframework.stereotype.Service;

@Service
public interface RouteService {
    void add(AddRouteDTO addRouteDTO);
}
