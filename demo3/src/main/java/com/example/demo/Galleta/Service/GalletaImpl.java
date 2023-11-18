package com.example.demo.Galleta.Service;

import com.example.demo.Galleta.Domain.Galleta;
import com.example.demo.Galleta.Domain.GalletaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class GalletaImpl implements GalletaService{

    @Autowired
    private GalletaRepository galletaRepository;


    @Override
    public void deleteGalleta(Long id) {
        galletaRepository.deleteById(id);
    }

    @Override
    public Page<Galleta> getAllGalletas(Pageable pageable) {
        return galletaRepository.findAll(pageable);
    }


    @Override
    public Galleta insertGalleta(Galleta galleta) {
        return galletaRepository.save(galleta);
    }

    @Override
    public Galleta actualizarGalleta(Long id, Galleta galleta) {
        Galleta existGalleta = galletaRepository.findById(id).orElse(null);
        if (existGalleta != null) {
            existGalleta.setDescripcion(galleta.getDescripcion());
            existGalleta.setImg(galleta.getImg());
            existGalleta.setNombre(galleta.getNombre());
            existGalleta.setisOctogono(galleta.getisOctogono());
            existGalleta.setStock(galleta.getStock());

            return galletaRepository.save(existGalleta);
        } else {
            return null;
        }
    }

    @Override
    public Optional<Galleta> buscarPorId(Long id) {
        return galletaRepository.findById(id);
    }

}
