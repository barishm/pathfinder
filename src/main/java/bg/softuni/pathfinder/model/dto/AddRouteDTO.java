package bg.softuni.pathfinder.model.dto;

import bg.softuni.pathfinder.model.CategoryNames;
import bg.softuni.pathfinder.model.Level;

import java.util.Set;

public class AddRouteDTO {
    private String name;
    private String description;
    private Level level;
    private String videoUrl;
    private Set<CategoryNames> categories;

    public Set<CategoryNames> getCategories() {
        return categories;
    }

    public void setCategories(Set<CategoryNames> categories) {
        this.categories = categories;
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
}
