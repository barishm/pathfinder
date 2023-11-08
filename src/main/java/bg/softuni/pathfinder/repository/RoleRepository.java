package bg.softuni.pathfinder.repository;

import bg.softuni.pathfinder.model.Role;
import bg.softuni.pathfinder.model.UserRoles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByName(UserRoles userRoles);
}
