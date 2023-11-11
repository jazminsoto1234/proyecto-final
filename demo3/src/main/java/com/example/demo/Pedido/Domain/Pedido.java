package com.example.demo.Pedido.Domain;

import com.example.demo.Carrito.Domain.Carrito;
import com.example.demo.User.Domain.User;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Pedido {
    @Id
    private Long id;

    private Date fechaCreation;

    private Double subtotal;

    private Double montoTotal;

    private Double igv;

    private String estado;

    @OneToMany(mappedBy = "pedido")
    private List<Carrito> carritos;

    //Usar esto
    @ManyToOne
    private User user;

    public Pedido() {}

    public Pedido(Long id, Date fechaCreation, Double subtotal, Double montoTotal, Double igv, String estado, List<Carrito> carritos){
        this.id = id; this.montoTotal = montoTotal;
        this.fechaCreation = fechaCreation;
        this.igv = igv; this.estado = estado;
        this.subtotal = subtotal;
        this.carritos = carritos;
    }

    //Getters and setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaCreation() {
        return fechaCreation;
    }

    public void setFechaCreation(Date fechaCreation) {
        this.fechaCreation = fechaCreation;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(Double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public Double getIgv() {
        return igv;
    }

    public void setIgv(Double igv) {
        this.igv = igv;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<Carrito> getCarritos() {
        return carritos;
    }

    public void setCarritos(List<Carrito> carritos) {
        this.carritos = carritos;
    }
}
