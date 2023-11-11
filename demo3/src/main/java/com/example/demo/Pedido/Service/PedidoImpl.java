package com.example.demo.Pedido.Service;

import com.example.demo.Carrito.Service.CarritoService;
import com.example.demo.Pedido.Domain.Pedido;
import com.example.demo.Pedido.Domain.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoImpl implements PedidoService{
    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private CarritoService carritoService;

    @Override
    public void deletePedido(Long id) {
        pedidoRepository.deleteById(id);

    }

    @Override
    public List<Pedido> getAllPedidos() {
        return pedidoRepository.findAll();
    }

    @Override
    public Optional<Pedido> buscarPedidoById(Long id) {
        return pedidoRepository.findById(id);
    }

    @Override
    public Pedido actualizarPedido(Long id, Pedido pedido) {
        Optional<Pedido> existPedido = pedidoRepository.findById(id);
        if(existPedido.isPresent()){
            Pedido pedidoup = existPedido.get();
            pedidoup.setEstado(pedido.getEstado());
            pedidoup.setIgv(pedido.getIgv());
            pedidoup.setFechaCreation(pedido.getFechaCreation());
            pedidoup.setSubtotal(pedido.getSubtotal());
            pedidoup.setMontoTotal(pedido.getMontoTotal());
            pedidoup.setCarritos(pedido.getCarritos());
            return pedidoRepository.save(pedidoup);
        }else{
            return null;
        }

    }

    @Override
    public Pedido insertarPedido(Pedido pedido) {

        carritoService.guardarListaCarritos(pedido.getCarritos());
        return pedidoRepository.save(pedido);
    }
}
