package bg.softuni.pathfinder.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class RouteDetailsViewModel {
    private Long id;
    private String name;
    private String level;
    private String description;
    private String videoUrl;
    private String authorName;

}
