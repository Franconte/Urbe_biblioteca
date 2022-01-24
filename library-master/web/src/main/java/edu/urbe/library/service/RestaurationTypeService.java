/*
 * Copyright (C) Universidad Privada Dr Rafael Belloso Chacin.
 * Todos los derechos reservados.
 * La divulgación de este material está estrictamente prohibida a menos
 * que cuente con una autorización escrita por parte del propietario o
 * alguna de sus subsidiarias.
 */
package edu.urbe.library.service;

import edu.urbe.library.entity.RestaurationType;
import edu.urbe.library.exception.EntityNotFound;
import edu.urbe.library.repository.RestaurationTypeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Este servicio contiene toda la logica relacionada con los tipos de restauracion ({@link RestaurationType}).
 * @author David Soles
 */
@Service
public class RestaurationTypeService {

    private static final Logger logger = LoggerFactory.getLogger(RestaurationTypeService.class);

    private CommonService commonService;
    private RestaurationTypeRepository restaurationTypeRepository;

    public RestaurationTypeService(CommonService commonService, RestaurationTypeRepository restaurationTypeRepository) {
        this.commonService = commonService;
        this.restaurationTypeRepository = restaurationTypeRepository;
    }

    /**
     * @return Retorna una lista con los tipos de restauracion (RestaurationType).
     */
    public List<RestaurationType> findAll() {
        logger.debug("findAll");
        return restaurationTypeRepository.findAll();
    }

    /**
     * @param id Identificador de una entidad de tipo RestaurationType.
     * @return Retorna una entidad opcional de tipo RestaurationType.
     */
    public Optional<RestaurationType> restaurationTypeById(Integer id) {
        logger.debug("restaurationTypeById "+ id);
        Optional<RestaurationType> restaurationTypeOptional = restaurationTypeRepository.findById(id);
        logger.debug("restaurationTypeById "+ restaurationTypeOptional.toString());
        if (!restaurationTypeOptional.isPresent())
            throw new EntityNotFound("No hay resultado por el id = " + id);
        return restaurationTypeOptional;
    }

    /**
     * @param restaurationType Objeto de tipo RestaurationType que sera almacenado en la base de datos.
     * @return Retorna la entidad de tipo RestaurationType que fue almacenada en la base de datos.
     */
    public RestaurationType addRestaurationType(RestaurationType restaurationType) {
        logger.debug("addRestaurationType " + restaurationType.toString());
        restaurationType.setIdTipoRestauracion(commonService.getMaxId("id_tipo_restauracion"));
        return restaurationTypeRepository.save(restaurationType);
    }

    /**
     * @param restaurationType Objeto de tipo RestaurationType que sera actualizado en la base de datos.
     * @param id Identificador de la entidad RestaurationType que sera actualizada.
     * @return Retorna la entidad RestaurationType con los datos actualizados.
     */
    public RestaurationType updateRestaurationType(RestaurationType restaurationType, Integer id) {
        logger.debug("updateRestaurationType "+ restaurationType.toString());
        Optional<RestaurationType> restaurationTypeOptional = restaurationTypeRepository.findById(id);
        logger.debug("restaurationTypeOptional "+ restaurationTypeOptional.toString());
        if (!restaurationTypeOptional.isPresent())
            throw new EntityNotFound("No hay resultado por el tag = " + id);
        return restaurationTypeRepository.update(restaurationType);
    }

    /**
     * @param id Identificador de la entidad RestaurationType que sera eliminada.
     */
    public void deleteRestaurationType(Integer id) {
        logger.debug("deleteRestaurationType " + id);
        Optional<RestaurationType> restaurationTypeOptional = restaurationTypeRepository.findById(id);
        logger.debug("restaurationTypeOptional " + restaurationTypeOptional.toString());
        if (!restaurationTypeOptional.isPresent())
            throw new EntityNotFound("No hay resultado por el tag = " + id);
        restaurationTypeRepository.delete(id);
    }

}
