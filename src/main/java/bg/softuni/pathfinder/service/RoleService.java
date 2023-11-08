package bg.softuni.pathfinder.service;

import bg.softuni.pathfinder.model.Role;
import org.springframework.stereotype.Service;

@Service
public interface RoleService {

    Role getRoleByName (String name);
}