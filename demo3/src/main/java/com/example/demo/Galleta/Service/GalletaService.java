package com.example.demo.Galleta.Service;


import com.example.demo.Galleta.Domain.Galleta;

import java.util.List;
import java.util.Optional;
import java.util.Set;


public interface GalletaService {

    public abstract void deleteGalleta(Long id);
    public abstract List<Galleta> getAllGalletas();

    public abstract Galleta insertGalleta(Galleta galleta);

    public abstract Galleta actualizarGalleta(Long id, Galleta galleta);

    public abstract Optional<Galleta> buscarPorId(Long id);




}
