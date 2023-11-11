package com.example.demo.Pedido.Application;

import com.example.demo.Pedido.Domain.Pedido;
import com.example.demo.Pedido.Service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public ResponseEntity<List<Pedido>> getAllpedidos(){
        List<Pedido> listaPedido = pedidoService.getAllPedidos();
        return ResponseEntity.status(200).body(listaPedido);
    }


    @GetMapping("{id}")
    public ResponseEntity<Pedido> getPedidoId(@PathVariable Long id){
        Optional<Pedido> existPedido = pedidoService.buscarPedidoById(id);
        if(existPedido.isPresent()){
            return ResponseEntity.status(200).body(existPedido.get());
        }else{
            return null; //Por ahora esto
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> eliminarPedido(@PathVariable Long id){
        pedidoService.deletePedido(id);
        return ResponseEntity.status(200).body("Deleted");
    }

    @PutMapping("{id}")
    public ResponseEntity<Pedido> updatePedido(@PathVariable Long id, @RequestBody Pedido pedido){
        Pedido upPedido  = pedidoService.actualizarPedido(id, pedido);
        return ResponseEntity.status(200).body(upPedido);
    }

    @PostMapping
    public ResponseEntity<String> postPedido(@RequestBody Pedido pedido){
        pedidoService.insertarPedido(pedido);
        return ResponseEntity.status(201).body("Created");
    }


}
