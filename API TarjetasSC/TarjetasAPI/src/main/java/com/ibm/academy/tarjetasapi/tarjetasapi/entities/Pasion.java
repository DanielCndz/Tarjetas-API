package com.ibm.academy.tarjetasapi.tarjetasapi.entities;

import lombok.*;

import javax.persistence.Embeddable;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Embeddable
public class Pasion implements Serializable
{
    @NotNull(message = "El campo preferencia no puede ser nulo")
    @NotEmpty(message = "El campo preferencia no puede estar vacio")
    private String preferencia;

    @NotNull(message = "El campo salarioMin no puede ser nulo")
    @NotEmpty(message = "El campo salarioMin no puede estar vacio")
    @DecimalMin(value = "7000",message = "Salario inferior al requerido")
    private Integer salarioMin;

    @NotNull(message = "El campo salarioMax no puede ser nulo")
    @NotEmpty(message = "El campo salarioMax no puede estar vacio")
    private Integer salarioMax;

    @NotNull(message = "El campo edadMin no puede ser nulo")
    @NotEmpty(message = "El campo edadMin no puede estar vacio")
    @DecimalMin(value = "18",message = "La edad minima requerida es de 18 anios")
    private Integer edadMin;

    @NotNull(message = "El campo edadMax no puede ser nulo")
    @NotEmpty(message = "El campo edadMax no puede estar vacio")
    @DecimalMax(value = "75",message = "La edad maxima es de 75 anios")
    private Integer edadMax;

    private static final long serialVersionUID = 2665340349207534083L;
}
