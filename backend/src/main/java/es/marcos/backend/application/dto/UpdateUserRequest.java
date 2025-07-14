package es.marcos.backend.application.dto;

import es.marcos.backend.domain.enums.UserRole;
import es.marcos.backend.domain.enums.UserState;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class UpdateUserRequest {

    @Size(max = 100, message = "El nombre no puede superar 100 caracteres.")
    private String name;

    @Size(max = 100, message = "Los apellidos no pueden superar 100 caracteres.")
    private String surname;

    @Size(max = 20, message = "El DNI no puede superar 20 caracteres.")
    private String dni;

    @Past
    private LocalDate birthDate;

    @Size(max = 500, message = "La dirección no puede superar 500 caracteres.")
    private String address;

    @Size(max = 10, message = "El código postal no puede superar 10 caracteres.")
    private String zipCode;

    @Size(max = 50, message = "La localidad no puede superar 50 caracteres.")
    private String town;

    @Size(max = 50, message = "La provincia no puede superar 50 caracteres.")
    private String province;

    @Size(max = 20, message = "El teléfono no puede superar 20 caracteres.")
    private String telephone;

    @Size(max = 20, message = "El móvil no puede superar 20 caracteres.")
    private String mobilePhone;

    @Email(message = "El email debe ser válido.")
    @Size(max = 100, message = "El email no puede superar 100 caracteres.")
    private String email;

    @Size(max = 100, message = "El nombre de la entidad no puede superar 100 caracteres.")
    private String bankName;

    @Size(max = 34, message = "El IBAN no puede superar 34 caracteres.")
    private String iban;

    private Boolean receivesNotifications;
    private Boolean imageConsent;
    private Boolean acceptPayments;

    private UserRole userRole;
    private UserState userState;



    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }

    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getZipCode() { return zipCode; }
    public void setZipCode(String zipCode) { this.zipCode = zipCode; }

    public String getTown() { return town; }
    public void setTown(String town) { this.town = town; }

    public String getProvince() { return province; }
    public void setProvince(String province) { this.province = province; }

    public String getTelephone() { return telephone; }
    public void setTelephone(String telephone) { this.telephone = telephone; }

    public String getMobilePhone() { return mobilePhone; }
    public void setMobilePhone(String mobilePhone) { this.mobilePhone = mobilePhone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getBankName() { return bankName; }
    public void setBankName(String bankName) { this.bankName = bankName; }

    public String getIban() { return iban; }
    public void setIban(String iban) { this.iban = iban; }

    public Boolean getReceivesNotifications() { return receivesNotifications; }
    public void setReceivesNotifications(Boolean receivesNotifications) { this.receivesNotifications = receivesNotifications; }

    public Boolean getImageConsent() { return imageConsent; }
    public void setImageConsent(Boolean imageConsent) { this.imageConsent = imageConsent; }

    public Boolean getAcceptPayments() { return acceptPayments; }
    public void setAcceptPayments(Boolean acceptPayments) { this.acceptPayments = acceptPayments; }

    public UserRole getUserRole() { return userRole; }
    public void setUserRole(UserRole userRole) { this.userRole = userRole; }

    public UserState getUserState() { return userState; }
    public void setUserState(UserState userState) { this.userState = userState; }
}
