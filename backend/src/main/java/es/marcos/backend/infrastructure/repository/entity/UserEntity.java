package es.marcos.backend.infrastructure.repository.entity;


import es.marcos.backend.domain.enums.UserRole;
import es.marcos.backend.domain.enums.UserState;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "socios")
public class UserEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String name;

    @Column(name = "apellidos", nullable = false)
    private String surname;

    @Column(name = "dni", nullable = false)
    private String dni;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDate birthDate;

    @Column(name = "direccion")
    private String address;

    @Column(name = "codigo_postal", nullable = false)
    private String zipCode;

    @Column(name = "localidad")
    private String town;

    @Column(name = "provincia")
    private String province;

    @Column(name = "telefono")
    private String telephone;


    @Column(name = "movil", nullable = false)
    private String mobilePhone;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "nombre_entidad", nullable = false)
    private String bankName;

    @Column(name = "iban", nullable = false, length = 34)
    private String iban;

    @Column(name = "recibe_notificaciones", nullable = false)
    private Boolean receivesNotifications;

    @Column(name = "consiente_imagenes", nullable = false)
    private Boolean imageConsent;

    @Column(name = "acepta_cuota", nullable = false)
    private Boolean acceptPayments;

    @Column(name = "fecha_alta", nullable = false)
    private LocalDateTime registerDate;

    @Column(name = "fecha_baja")
    private LocalDateTime removeDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_state", nullable = false)
    private UserState userState;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_role", nullable = false)
    private UserRole userRole;


    protected UserEntity() {}

    public UserEntity(Long id,
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public UserState getUserState() {
        return userState;
    }

    public void setUserState(UserState userState) {
        this.userState = userState;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }
}
