package com.example.demo.Carrito.Application;

import com.example.demo.Carrito.Domain.Carrito;
import com.example.demo.Carrito.Service.CarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carrito")
public class CarritoController {
    @Autowired
    private CarritoService carritoService;

    @GetMapping
    public ResponseEntity<List<Carrito>> getAllCarritos(){
        List<Carrito> listaCarritos = carritoService.listarCarritos();
        return ResponseEntity.status(200).body(listaCarritos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carrito> getCarritoId(@PathVariable Long id){
        Carrito carrito = carritoService.buscarPorId(id).get();
        return ResponseEntity.status(200).body(carrito);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarCarrito(@PathVariable Long id){
        carritoService.deleteCarrito(id);
        return ResponseEntity.status(200).body("Deleted");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Carrito> putCarrito(@PathVariable Long id, @RequestBody Carrito carrito){
        Carrito actualizarCarrito = carritoService.actualizarCarrito(id, carrito);
        return ResponseEntity.status(200).body(actualizarCarrito);
    }

    @PostMapping
    public ResponseEntity<String> postCarrito(@RequestBody Carrito carrito){
        carritoService.insertCarrito(carrito);
        return ResponseEntity.status(201).body("Created");
    }


}
