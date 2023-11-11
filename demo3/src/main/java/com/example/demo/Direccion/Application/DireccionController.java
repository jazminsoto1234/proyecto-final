package com.example.demo.Direccion.Application;
import com.example.demo.Direccion.Exceptions.DireccionExceptionHandler;
import com.example.demo.Direccion.Domain.Direccion;
import com.example.demo.Direccion.Exceptions.DireccionNotFoundException;
import com.example.demo.Direccion.Service.DireccionImpl;
import com.example.demo.Direccion.Service.DireccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/direccion")
public class DireccionController {

    @Autowired
    private DireccionService direccionService;

    @Autowired
    private DireccionExceptionHandler direccionExceptionHandler;

    @GetMapping
    public ResponseEntity<List<Direccion>> GetAllDireccion(){
        List<Direccion> direcciones = direccionService.getAllDireccion();
        return ResponseEntity.status(200).body(direcciones);
    }

    @GetMapping("/{id}") //Manejando el error de que no se encuentre esa direccion
    public ResponseEntity<Direccion> GetDireccionId(@PathVariable Long id){
        try {
            Direccion direccion = direccionService.getByIdDireccion(id).get();
            return ResponseEntity.status(200).body(direccion);
        }catch (DireccionNotFoundException e){

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<String> PostDireccion(@RequestBody Direccion direccion){
        direccionService.insertarDireccion(direccion);
        return ResponseEntity.status(200).body("Created");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> EliminarDireccion(@PathVariable Long id){
        direccionService.deleteDireccion(id);
        return  ResponseEntity.status(200).body("Deleted");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Direccion> PutDireccion(@RequestBody Direccion direccion, @PathVariable Long id){
        Direccion direccionactualizado =  direccionService.actualizarDireccion(id, direccion);
        return ResponseEntity.status(200).body(direccionactualizado);
    }



}
