package com.ibm.academy.tarjetasapi.tarjetasapi.repositories;

import com.ibm.academy.tarjetasapi.tarjetasapi.entities.Tarjeta;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarjetaRepository extends CrudRepository<Tarjeta,Integer>
{
    @Query("select t from Tarjeta t where upper(t.pasion.preferencia) = upper(?1) and (t.pasion.edadMin <= ?2 and t.pasion.edadMax >= ?2) " +
            "and (t.pasion.salarioMin <= ?3 and t.pasion.salarioMax >= ?3)")
    public Iterable<Tarjeta> buscarTarjetas(String preferencia, Integer edad, Integer sueldo);
}
