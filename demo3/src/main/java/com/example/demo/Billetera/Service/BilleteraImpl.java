package com.example.demo.Billetera.Service;

import com.example.demo.Billetera.Domain.Billetera;
import com.example.demo.Billetera.Exceptions.SaldoInsuficienteException;
import com.example.demo.Billetera.Domain.BilleteraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BilleteraImpl implements BilleteraService {

    @Autowired
    private BilleteraRepository billeteraRepository;

    @Override
    public double getSaldo(Long id) {
        Billetera billetera = billeteraRepository.findById(id).orElseThrow(() -> new RuntimeException("Billetera no encontrada"));
        return billetera.getSaldo();
    }

    @Override
    public void recargarSaldo(Long id, double monto) {
        Billetera billetera = billeteraRepository.findById(id).orElseThrow(() -> new RuntimeException("Billetera no encontrada"));
        billetera.setSaldo(billetera.getSaldo() + monto);
        billeteraRepository.save(billetera);
    }

    @Override
    public void realizarPago(Long id, double monto) {
        Billetera billetera = billeteraRepository.findById(id).orElseThrow(() -> new RuntimeException("Billetera no encontrada"));
        if (billetera.getSaldo() >= monto) {
            billetera.setSaldo(billetera.getSaldo() - monto);
            billeteraRepository.save(billetera);
        } else {
            throw new SaldoInsuficienteException("Saldo insuficiente para realizar el pago");
        }
    }
}