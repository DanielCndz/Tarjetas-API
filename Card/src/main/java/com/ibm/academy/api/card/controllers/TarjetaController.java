package com.ibm.academy.api.card.controllers;

import com.ibm.academy.api.card.entities.Persona;
import com.ibm.academy.api.card.entities.Tarjeta;
import com.ibm.academy.api.card.exceptions.NotFoundException;
import com.ibm.academy.api.card.mapper.TarjetaMapper;
import com.ibm.academy.api.card.services.TarjetaDAOImp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/tarjetas")
public class TarjetaController
{
    Logger logger = LoggerFactory.getLogger(TarjetaController.class);

    @Autowired
    public TarjetaMapper tarjetaMapper;

    @Autowired
    public TarjetaDAOImp tarjetaDAO;

    /**
     * Enpoint que guarda nuevas tarjetas de credito en la base de datos
     * @param tarjeta Objeto tipo tarjeta con la informacion a guardar
     * @param result Variable para la validacion de los argumentos ingresados
     * @return Informacion de la tarjeta guardada
     * @Author DYMS 25/05/2022
     */
    @PostMapping("/add")
    public ResponseEntity<?> guardarTarjeta(@Valid @RequestBody Tarjeta tarjeta, BindingResult result)
    {
        Map<String,Object> validaciones = new HashMap<String,Object>();
        if(result.hasErrors())
        {
            List<String> listaErrores = result.getFieldErrors().stream().map(errores->"Campo: "+errores.getField()+" "+errores.getDefaultMessage()).collect(toList());
            validaciones.put("Lista Errores",listaErrores);
            return new ResponseEntity<Map<String,Object>>(validaciones,HttpStatus.BAD_REQUEST);
        }

        Tarjeta tarjetaSave = tarjetaDAO.guardarTarjeta(tarjeta);
        return new ResponseEntity<Tarjeta>(tarjetaSave,HttpStatus.CREATED);
    }

    /**
     * Endpoint que elimina un elemnto Tarjeta de la abse de datos
     * @param id identificador de la tarjeta a borrar
     * @return informacion de la tarjeta borrada
     * @Author DYMS 25/05/2022
     */
    @DeleteMapping("/del/id/{id}")
    public ResponseEntity<?> eliminarPorId(@PathVariable Integer id) {
        Optional<Tarjeta> oTarjeta = tarjetaDAO.buscarTarjetaPorId(id);
        if (!oTarjeta.isPresent())
            throw new NotFoundException(String.format("Tarjeta con ID %d no encontrada",id));
        tarjetaDAO.eliminarTarjetaPorId(id);
        return new ResponseEntity<Tarjeta>(oTarjeta.get(), HttpStatus.OK);
    }

    /**
     * Endpoint que muestra las tarjetas recomendadas a un objeto tipo persona deacuerdo a la informacion de su perfil
     * @param persona Objeto tipo persona que incluye la informacion necesaria para asociarlo a una tarjeta
     * @param result Variable para la validacion de los argumentos ingresados
     * @return Una lista de los nombres de las tarjetas recomendadas para el objeto de tipo persona
     * @Author DYMS 25/05/2022
     */
    @GetMapping("/get/cards")
    public ResponseEntity<?> buscarTarjetas(@Valid @RequestBody Persona persona, BindingResult result)
    {
        Map<String,Object> validaciones = new HashMap<String,Object>();
        if(result.hasErrors())
        {
            List<String> listaErrores = result.getFieldErrors().stream().map(errores->"Campo: "+errores.getField()+" "+errores.getDefaultMessage()).collect(toList());
            validaciones.put("Lista Errores",listaErrores);
            return new ResponseEntity<Map<String,Object>>(validaciones,HttpStatus.BAD_REQUEST);
        }

        List<Tarjeta> tarjetas= (List<Tarjeta>) tarjetaDAO.buscarTarjetas(persona.getPreferencia(), persona.getEdad(),persona.getSalario());
        if (tarjetas.isEmpty())
            throw new NotFoundException(String.format("No hay tarjetas recomendadas para usted"));
        tarjetas.forEach(tarjeta -> tarjetaMapper.mapeoTarjeta((Tarjeta) tarjeta));

        return new ResponseEntity<>(tarjetas.stream().map(TarjetaMapper::mapeoTarjeta).collect(toList()), HttpStatus.OK);
    }

}
