package bg.softuni.pathfinder.model;

import java.util.List;

public enum Level {
    BEGINNER, INTERMEDIATE, ADVANCED;

    public static List<Level> getEnumsAsList() {
        return List.of(Level.BEGINNER,Level.INTERMEDIATE,Level.ADVANCED);
    }
}
