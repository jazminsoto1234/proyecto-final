package com.example.demo.Carrito.Domain;

import com.example.demo.Galleta.Domain.Galleta;
import com.example.demo.Pedido.Domain.Pedido;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class Carrito {
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "galleta_id")
    private Galleta galleta;

    //@JsonIgnore
    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    private Double precio;

    private Integer cantidad;

    public Carrito() {}

    public Carrito(Long id, Galleta galleta, Pedido pedido, Double precio, Integer cantidad){
        this.cantidad = cantidad; this.id = id;
        this.galleta = galleta; this.pedido = pedido; this.precio = precio;
    }

    //Getter and setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Galleta getGalleta() {
        return galleta;
    }

    public void setGalleta(Galleta galleta) {
        this.galleta = galleta;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}