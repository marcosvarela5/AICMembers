package es.marcos.backend.application.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public class UserRegistrationCommand {

    @NotBlank
    @Size(max = 100)
    private String name;

    @NotBlank
    @Size(max = 100)
    private String surname;

    @NotBlank
    @Size(max = 20)
    private String dni;

    @NotNull
    @Past
    private LocalDate birthDate;

    @Size(max = 500)
    private String address;

    @NotBlank
    @Size(max = 10)
    private String zipCode;

    @Size(max = 50)
    private String town;

    @Size(max = 50)
    private String province;

    @Size(max = 20)
    private String telephone;

    @NotBlank
    @Size(max = 20)
    private String mobilePhone;

    @NotBlank
    @Email
    @Size(max = 100)
    private String email;

    @NotBlank
    @Size(min = 6)
    private String password;

    @NotBlank
    @Size(max = 100)
    private String bankName;

    @NotBlank
    @Size(max = 34)
    private String iban;

    @NotNull
    private Boolean receivesNotifications;

    @NotNull
    private Boolean imageConsent;

    @NotNull
    private Boolean acceptPayments;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
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

    public String getMobilePhone() {
        return mobilePhone;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
}
