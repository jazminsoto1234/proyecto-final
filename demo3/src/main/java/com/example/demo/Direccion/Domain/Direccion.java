package com.example.demo.Direccion.Domain;

import com.example.demo.User.Domain.User;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Direccion {
    @Id
    private Long id;

    private String ciudad;

    private String provincia;

    private String calle;

    private String referencia;

    @OneToMany
    private List<User> users;

    public Direccion() {}

    public Direccion(Long id, String ciudad, String provincia, String calle, String referencia, List<User> users){
        this.id = id; this.ciudad = ciudad;
        this.provincia = provincia; this.calle = calle;
        this.referencia = referencia;
        this.users = users;
    }

    //Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
