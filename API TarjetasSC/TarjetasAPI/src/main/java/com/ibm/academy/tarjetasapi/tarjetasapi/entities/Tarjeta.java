package com.ibm.academy.tarjetasapi.tarjetasapi.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.io.Serializable;
import java.util.Objects;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "tarjetas",schema = "tarjetas")
public class Tarjeta implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "preferencia", column = @Column(name = "preferencia")),
            @AttributeOverride(name = "salarioMin", column = @Column(name = "salario_min")),
            @AttributeOverride(name = "salarioMax", column = @Column(name = "salario_max")),
            @AttributeOverride(name = "edadMin", column = @Column(name = "edad_minima")),
            @AttributeOverride(name = "edadMax", column = @Column(name = "edad_maxima"))
    })
    private Pasion pasion;

    @Column(name = "fecha_creacion")
    private Date fechaCreacion;

    @Column(name = "fecha_modificacion")
    private Date fechaModificacion;

    @PrePersist
    private void antesPersistir()
    {this.fechaCreacion=new Date();}

    @PreUpdate
    private  void antesActualizar()
    {this.fechaModificacion=new Date();}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tarjeta tarjeta = (Tarjeta) o;
        return Objects.equals(id, tarjeta.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    private static final long serialVersionUID = -8311086397246188614L;
}
