package com.ibm.academy.api.card.services;

import com.ibm.academy.api.card.entities.Tarjeta;


import java.util.Optional;

public interface TarjetaDAO
{
    public Optional<Tarjeta> buscarTarjetaPorId(Integer id);
    public Tarjeta guardarTarjeta(Tarjeta tarjeta);
    public void eliminarTarjetaPorId(Integer id);
        public Iterable<Tarjeta> buscarTarjetas(String preferencia, Integer edad, Integer salario);
}
