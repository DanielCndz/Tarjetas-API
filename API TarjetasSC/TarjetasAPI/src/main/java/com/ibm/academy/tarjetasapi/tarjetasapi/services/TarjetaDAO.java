package com.ibm.academy.tarjetasapi.tarjetasapi.services;

import com.ibm.academy.tarjetasapi.tarjetasapi.entities.Tarjeta;

import java.math.BigDecimal;
import java.util.Optional;

public interface TarjetaDAO
{
    public Optional<Tarjeta> buscarTarjetaPorId(Integer id);
    public Tarjeta guardarTarjeta(Tarjeta tarjeta);
    public void eliminarTarjetaPorId(Integer id);
        public Iterable<Tarjeta> buscarTarjetas(String preferencia, Integer edad, Integer salario);
}
