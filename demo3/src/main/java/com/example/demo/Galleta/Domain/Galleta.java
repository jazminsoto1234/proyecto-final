package com.example.demo.Galleta.Domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Galleta {
    @Id
    private  Long id;

    private String nombre;

    private Integer stock;

    private String descripcion;

    private Boolean isOctogono;

    private String img;

    public Galleta() {}

    public Galleta(Long id, String nombre, Integer stock, String descripcion, Boolean isOctogono, String img){
        this.id = id; this.nombre = nombre;
        this.descripcion = descripcion; this.isOctogono = isOctogono;
        this.img = img;
    }


    //Getter and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getisOctogono() {
        return isOctogono;
    }

    public void setisOctogono(Boolean isOctogono) {
        this.isOctogono = isOctogono;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
