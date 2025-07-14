package es.marcos.backend.domain.model;

import es.marcos.backend.domain.enums.UserRole;
import es.marcos.backend.domain.enums.UserState;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class User {

    private Long id;
    private String name;
    private String surname;
    private String dni;
    private String password;
    private LocalDate birthDate;
    private String address;
    private String zipCode;
    private String town;
    private String province;
    private String telephone;
    private String mobilePhone;
    private String email;
    private String bankName;
    private String iban;
    private Boolean receivesNotifications = false;
    private Boolean imageConsent = false;
    private Boolean acceptPayments = false;
    private UserRole userRole;
    private UserState userState;

    private LocalDateTime registerDate = LocalDateTime.now();
    private LocalDateTime removeDate;

    public User() {}

    public User(Long id,
                String name,
                String surname,
                String dni,
                String password,
                LocalDate birthDate,
                String address,
                String zipCode,
                String town,
                String province,
                String telephone,
                String mobilePhone,
                String email,
                String bankName,
                String iban,
                Boolean receivesNotifications,
                Boolean imageConsent,
                Boolean acceptPayments,
                LocalDateTime registerDate,
                LocalDateTime removeDate,
                UserState userState,
                UserRole userRole) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.dni = dni;
        this.password = password;
        this.birthDate = birthDate;
        this.address = address;
        this.zipCode = zipCode;
        this.town = town;
        this.province = province;
        this.telephone = telephone;
        this.mobilePhone = mobilePhone;
        this.email = email;
        this.bankName = bankName;
        this.iban = iban;
        this.receivesNotifications = receivesNotifications;
        this.imageConsent = imageConsent;
        this.acceptPayments = acceptPayments;
        this.registerDate = registerDate;
        this.removeDate = removeDate;
        this.userState = userState;
        this.userRole = userRole;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public Boolean getReceivesNotifications() {
        return receivesNotifications;
    }

    public void setReceivesNotifications(Boolean receivesNotifications) {
        this.receivesNotifications = receivesNotifications;
    }

    public Boolean getImageConsent() {
        return imageConsent;
    }

    public void setImageConsent(Boolean imageConsent) {
        this.imageConsent = imageConsent;
    }

    public Boolean getAcceptPayments() {
        return acceptPayments;
    }

    public void setAcceptPayments(Boolean acceptPayments) {
        this.acceptPayments = acceptPayments;
    }

    public LocalDateTime getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDateTime registerDate) {
        this.registerDate = registerDate;
    }

    public LocalDateTime getRemoveDate() {
        return removeDate;
    }

    public void setRemoveDate(LocalDateTime removeDate) {
        this.removeDate = removeDate;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getMobilePhone() {
        return mobilePhone;
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}
}
