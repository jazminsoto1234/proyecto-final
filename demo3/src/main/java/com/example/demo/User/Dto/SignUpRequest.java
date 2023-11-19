package com.example.demo.User.Dto;


import com.example.demo.Direccion.Domain.Direccion;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class SignUpRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    private Boolean isAdmin;

    @ManyToOne
    @JoinColumn(name = "direccion_id")
    private Direccion direccion;

    public SignUpRequest() {
    }

    public SignUpRequest(String firstName, String lastName, String email, String password, Boolean isAdmin, Direccion direccion ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.isAdmin = isAdmin;
        this.direccion = direccion;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
}
