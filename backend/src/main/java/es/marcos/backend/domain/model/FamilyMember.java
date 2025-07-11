package es.marcos.backend.domain.model;

import java.time.LocalDate;

public class FamilyMember {

    private Long id;
    private Socio socio;
    private String name;
    private String surname;
    private String familyBound;
    private LocalDate birthDate;
    private String dni;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
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

    public String getFamilyBound() {
        return familyBound;
    }

    public void setFamilyBound(String familyBound) {
        this.familyBound = familyBound;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
}