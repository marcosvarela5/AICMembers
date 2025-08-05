package es.marcos.backend.application.dto;

public class AuthenticatedUserDto {
    private String name;
    private String email;
    private String userRole;

    public AuthenticatedUserDto(String name, String email, String userRole) {
        this.name = name;
        this.email = email;
        this.userRole = userRole;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
