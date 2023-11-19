package com.example.demo.Billetera.Service;

public interface BilleteraService {

    double getSaldo(Long id);

    void recargarSaldo(Long id, double monto);

    void realizarPago(Long id, double monto);
}
