package com.example.demo.Billetera.Application;

import com.example.demo.Billetera.Exceptions.SaldoInsuficienteException;
import com.example.demo.Billetera.Service.BilleteraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/billetera")
public class BilleteraController {

    @Autowired
    private BilleteraService billeteraService;

    @GetMapping("/saldo/{id}")
    public ResponseEntity<Double> getSaldo(@PathVariable Long id) {
        double saldo = billeteraService.getSaldo(id);
        return ResponseEntity.status(200).body(saldo);
    }

    @PostMapping("/recargar/{id}")
    public ResponseEntity<String> recargarSaldo(@PathVariable Long id, @RequestParam double monto) {
        billeteraService.recargarSaldo(id, monto);
        return ResponseEntity.status(200).body("Saldo recargado exitosamente");
    }

    @PostMapping("/pagar/{id}")
    public ResponseEntity<String> pagar(@PathVariable Long id, @RequestParam double monto) {
        try {
            billeteraService.realizarPago(id, monto);
            return ResponseEntity.status(200).body("Pago realizado exitosamente");
        } catch (SaldoInsuficienteException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}