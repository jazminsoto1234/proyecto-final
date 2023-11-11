package com.example.demo.Carrito.Service;

import com.example.demo.Carrito.Domain.Carrito;
import com.example.demo.Carrito.Domain.CarritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarritoImpl implements CarritoService{

    @Autowired
    private CarritoRepository carritoRepository;
    @Override
    public void deleteCarrito(Long id) {
        carritoRepository.deleteById(id);
    }

    @Override
    public Carrito insertCarrito(Carrito carrito) {
        return carritoRepository.save(carrito);
    }

    @Override
    public Carrito actualizarCarrito(Long id, Carrito carrito) {
        Optional<Carrito> existCarrito = carritoRepository.findById(id);
        if(existCarrito.isPresent()){
            Carrito upcarrito = existCarrito.get();
            upcarrito.setGalleta(carrito.getGalleta());
            upcarrito.setPrecio(carrito.getPrecio());
            upcarrito.setPedido(carrito.getPedido());
            upcarrito.setCantidad(carrito.getCantidad());

            return carritoRepository.save(upcarrito);
        }else{
            return null;
        }
    }

    @Override
    public Optional<Carrito> buscarPorId(Long id) {
        return carritoRepository.findById(id);
    }

    @Override
    public List<Carrito> listarCarritos() {
        return carritoRepository.findAll();
    }


    @Override
    public List<Carrito> guardarListaCarritos(List<Carrito> carritos){
        return carritoRepository.saveAll(carritos);
    }
}
