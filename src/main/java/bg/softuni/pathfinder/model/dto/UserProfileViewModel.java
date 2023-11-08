package bg.softuni.pathfinder.model.dto;

import bg.softuni.pathfinder.model.Level;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class UserProfileViewModel {
    private String fullName;
    private String username;
    private int age;
    private Level level;
}
