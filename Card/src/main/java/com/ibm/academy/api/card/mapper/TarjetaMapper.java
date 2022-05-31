package com.ibm.academy.api.card.mapper;

import com.ibm.academy.api.card.entities.Tarjeta;
import com.ibm.academy.api.card.entities.dto.TarjetaDTO;
import org.springframework.stereotype.Component;

@Component
public class TarjetaMapper
{
    public static TarjetaDTO mapeoTarjeta(Tarjeta tarjeta)
    {
        return new TarjetaDTO(tarjeta.getNombre());
    }
}
