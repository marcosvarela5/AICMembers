package es.marcos.backend.domain.model;

import es.marcos.backend.domain.enums.UserRole;
import es.marcos.backend.domain.enums.UserState;

public class UserCriteria {

    private String name;
    private String surname;
    private UserRole userRole;
    private UserState userState;
    private Boolean imageConsent;
    private Boolean acceptsPayment;
    private Boolean receivesNotifications;

    // Getters y Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public UserState getUserState() {
        return userState;
    }

    public void setUserState(UserState userState) {
        this.userState = userState;
    }

    public Boolean getImageConsent() {
        return imageConsent;
    }

    public void setImageConsent(Boolean imageConsent) {
        this.imageConsent = imageConsent;
    }

    public Boolean getAcceptsPayment() {
        return acceptsPayment;
    }

    public void setAcceptsPayment(Boolean acceptsPayment) {
        this.acceptsPayment = acceptsPayment;
    }

    public Boolean getReceivesNotifications() {
        return receivesNotifications;
    }

    public void setReceivesNotifications(Boolean receivesNotifications) {
        this.receivesNotifications = receivesNotifications;
    }
}
