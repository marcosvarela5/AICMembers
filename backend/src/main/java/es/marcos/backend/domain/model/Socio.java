package es.marcos.backend.domain.model;

import java.time.LocalDate;
import java.util.List;

public class Socio {

    private Long id;
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

    private LocalDate registerDate = LocalDate.now();
    private LocalDate removeDate;

    private List<FamilyMember> familyMembers;

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

    public String getZipCode() {
        return zipCode;
    }

    public void setZIPcode(String ZIPcode) {
        this.zipCode = ZIPcode;
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

    public String getMobilephone() {
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

    public LocalDate getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDate registerDate) {
        this.registerDate = registerDate;
    }

    public LocalDate getRemoveDate() {
        return removeDate;
    }

    public void setRemoveDate(LocalDate removeDate) {
        this.removeDate = removeDate;
    }

    public List<FamilyMember> getFamilyMembers() {
        return familyMembers;
    }

    public void setFamilyMembers(List<FamilyMember> familyMembers) {
        this.familyMembers = familyMembers;
    }
}
