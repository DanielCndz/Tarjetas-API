package com.ibm.academy.api.card.services;


import com.ibm.academy.api.card.entities.Tarjeta;
import com.ibm.academy.api.card.repositories.TarjetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TarjetaDAOImp implements TarjetaDAO
{
    @Autowired
    public TarjetaRepository repository;

    @Override
    public Optional<Tarjeta> buscarTarjetaPorId(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Tarjeta guardarTarjeta(Tarjeta tarjeta) {
        return repository.save(tarjeta);
    }

    @Override
    public void eliminarTarjetaPorId(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Iterable<Tarjeta> buscarTarjetas(String preferencia, Integer edad, Integer salario) {
        return repository.buscarTarjetas(preferencia,edad,salario);
    }
}

