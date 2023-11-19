package com.example.demo.Billetera.Domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Billetera {

    @Id
    private Long id;

    private double saldo;

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}