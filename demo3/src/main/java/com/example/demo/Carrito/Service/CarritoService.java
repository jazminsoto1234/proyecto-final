package com.example.demo.Carrito.Service;

import com.example.demo.Carrito.Domain.Carrito;

import java.util.List;
import java.util.Optional;

public interface CarritoService {

    public abstract void deleteCarrito(Long id);

    public abstract Carrito insertCarrito(Carrito carrito);

    public abstract Carrito actualizarCarrito(Long id, Carrito carrito);

    public abstract Optional<Carrito> buscarPorId(Long id);

    public abstract List<Carrito> listarCarritos();

    public abstract List<Carrito> guardarListaCarritos(List<Carrito> carritos);
}
