package com.example.demo.Galleta.Application;

import com.example.demo.Galleta.Domain.Galleta;
import com.example.demo.Galleta.Service.GalletaImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/galletas")
public class GalletaController {
    @Autowired
    private GalletaImpl galletaService;

    @GetMapping
    public ResponseEntity<List<Galleta>> getGalletas() {
        List<Galleta> listaGalletas = galletaService.getAllGalletas();
        return ResponseEntity.status(200).body(listaGalletas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Galleta> getGalletaId(@PathVariable Long id){
        Optional<Galleta> existGalleta = galletaService.buscarPorId(id);
        if(existGalleta.isPresent()){
            return ResponseEntity.status(200).body(existGalleta.get());
        }else{
            return null;
        }
    }

    @PostMapping
    public ResponseEntity<String> createGalleta(@RequestBody Galleta galleta){
        galletaService.insertGalleta(galleta);
        return ResponseEntity.status(201).body("Created");
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> eleminarGalleta(@PathVariable Long id){
        galletaService.deleteGalleta(id);
        return ResponseEntity.status(200).body("Deleted");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Galleta> updateGalleta(@PathVariable Long id, @RequestBody Galleta galleta){
        Galleta actualizadaGalleta = galletaService.actualizarGalleta(id, galleta);
        return ResponseEntity.status(200).body(actualizadaGalleta);
    }




}
