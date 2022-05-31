package com.ibm.academy.tarjetasapi.tarjetasapi.mapper;

import com.ibm.academy.tarjetasapi.tarjetasapi.entities.Tarjeta;
import com.ibm.academy.tarjetasapi.tarjetasapi.entities.dto.TarjetaDTO;
import org.springframework.stereotype.Component;

@Component
public class TarjetaMapper
{
    public static TarjetaDTO mapeoTarjeta(Tarjeta tarjeta)
    {
        return new TarjetaDTO(tarjeta.getNombre());
    }
}
