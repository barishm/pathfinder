package bg.softuni.pathfinder.service.session;

import org.springframework.stereotype.Component;

@Component
public class LoggedUser {
    private String username;
    private String email;
    private String fullName;
    private boolean isLogged;

    public boolean isLogged() {
        return isLogged;
    }

    public void setLogged(boolean logged) {
        isLogged = logged;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void reset() {
        setUsername(null);
        setFullName(null);
        setEmail(null);
        setLogged(false);
    }
}
