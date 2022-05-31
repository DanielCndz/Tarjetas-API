package com.ibm.academy.tarjetasapi.tarjetasapi.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.io.Serializable;


@Setter
@Getter
@NoArgsConstructor
public class Persona implements Serializable
{
    @NotNull(message = "El campo preferencia no puede ser nulo")
    @NotEmpty(message = "El campo preferencia no puede estar vacio")
    private String preferencia;

    @DecimalMin(value = "7000",message = "Salario inferior al requerido")
    private Integer salario;

    @DecimalMin(value = "18",message = "La edad minima requerida es de 18 anios")
    @DecimalMax(value = "75",message = "La edad maxima es de 75 anios")
    private Integer edad;

    private static final long serialVersionUID = 9170852539484439412L;
}
