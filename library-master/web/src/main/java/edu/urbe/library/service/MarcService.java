/*
 * Copyright (C) Universidad Privada Dr Rafael Belloso Chacin.
 * Todos los derechos reservados.
 * La divulgación de este material está estrictamente prohibida a menos
 * que cuente con una autorización escrita por parte del propietario o
 * alguna de sus subsidiarias.
 */
package edu.urbe.library.service;

import edu.urbe.library.dto.MarcDTO;
import edu.urbe.library.entity.Marc;
import edu.urbe.library.exception.EntityNotFound;
import edu.urbe.library.repository.MarcRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Este servicio contiene toda la logica relacionada con las etiquetas Marc.
 * @author David Soles
 */
@Service
public class MarcService {

    private static final Logger logger = LoggerFactory.getLogger(MarcService.class);

    private MarcRepository marcRepository;

    public MarcService(MarcRepository marcRepository) {
        this.marcRepository = marcRepository;
    }

    /**
     * @return Retorna una lista de entidades de tipo Marc utilizando un DTO para ocultar ciertas
     * propiedades de la clase.
     */
    public List<MarcDTO> findAll() {
        return marcRepository.findAll()
                .stream().map(this::convertToDto).collect(Collectors.toList());
    }

    /**
     * @param marctag Identificador de la entidad Marc que se desea obtener.
     * @return Retorna una entidad opcional de tipo Marc.
     */
    public Optional<Marc> marcById(String marctag) {
        Optional<Marc> marc = marcRepository.findById(marctag);
        logger.debug("marcById " + marc.toString());
        if (!marc.isPresent())
            throw new EntityNotFound("No hay resultado por el marctag = " + marctag);
        return marc;
    }

    /**
     * @param marc Objeto de tipo Marc que contiene los datos que seran ingresados a la base de datos.
     * @return Entidad de tipo Marc que contiene los datos recien ingresados a la base de datos.
     */
    public Marc addMarc(Marc marc) {
        logger.debug("addMarc " + marc.toString());
        return marcRepository.save(marc);
    }

    /**
     * @param marc Objeto de tipo Marc que contiene los datos que seran actualizados en la base de datos.
     * @param marctag Identificador de la entidad Marc que sera actualizada.
     * @return Retorna una entidad Marc con los datos actualizados.
     */
    public Marc updateMarc(Marc marc, String marctag) {
        Optional<Marc> marcOptional = marcRepository.findById(marctag);
        logger.debug("updateMarc "+ marc.toString());
        if (!marcOptional.isPresent())
            throw new EntityNotFound("No hay resultado por el marctag = " + marctag);
        return marcRepository.update(marc);
    }

    /**
     * @param marctag Identificador de la entidad Marc que sera eliminada.
     */
    public void deleteMarc(String marctag) {
        Optional<Marc> marcOptional = marcRepository.findById(marctag);
        logger.debug("deleteMarc " + marctag);
        if (!marcOptional.isPresent())
            throw new EntityNotFound("No hay resultado por el marctag = " + marctag);
        marcRepository.delete(marcOptional.get().getMarctag());
    }

    private MarcDTO convertToDto(Marc marc) {
        return new ModelMapper().map(marc, MarcDTO.class);
    }
}
