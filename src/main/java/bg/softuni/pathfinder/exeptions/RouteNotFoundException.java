package bg.softuni.pathfinder.exeptions;

public class RouteNotFoundException extends RuntimeException{

    public RouteNotFoundException(String message) {
        super(message);
    }
}
