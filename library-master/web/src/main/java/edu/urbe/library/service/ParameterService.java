/*
 * Copyright (C) Universidad Privada Dr Rafael Belloso Chacin.
 * Todos los derechos reservados.
 * La divulgación de este material está estrictamente prohibida a menos
 * que cuente con una autorización escrita por parte del propietario o
 * alguna de sus subsidiarias.
 */
package edu.urbe.library.service;

import edu.urbe.library.dto.ParameterDTO;
import edu.urbe.library.entity.Parameter;
import edu.urbe.library.exception.EntityNotFound;
import edu.urbe.library.repository.ParameterRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Este servicio contiene toda la logica relacionada con el almacenamiento
 * y recuperacion de los parametros de la biblioteca.
 * @author David Soles
 */
@Service
public class ParameterService {

    private static final Logger logger = LoggerFactory.getLogger(ParameterService.class);
    
    @Value("${library.application.id}")
    private int applicationId;

    private CommonService commonService;
    private ParameterRepository parameterRepository;

    public ParameterService(CommonService commonService, ParameterRepository paramsRepository) {
        this.commonService = commonService;
        this.parameterRepository = paramsRepository;
    }

    /**
     * @return Retorna una lista de entidades de parametros.
     */
    public List<ParameterDTO> findAll() {
        List<Parameter> param = (List<Parameter>) parameterRepository.findAll(applicationId);
        logger.debug("findAll");
        return param.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    /**
     * @param id Identificador de la entidad Parameter.
     * @return Retorna una entidad opcional de Parameter.
     */
    public Optional<Parameter> findById(Integer id) {
        Optional<Parameter> params = parameterRepository.findById(id, applicationId);
        if (!params.isPresent())
            throw new EntityNotFound("No se encontro un resultado con el valor: " + id);
        logger.debug("findById " + id);
        return params;
    }

    /**
     * @param parameter Objeto de tipo Parameter que sera enviado a la capa de persistencia para ser almacenado.
     * @return Retorna una entidad de tipo Parameter con los datos que provienen de la capa de persistencia.
     */
    public Parameter addParams(Parameter parameter) {
        parameter.setIdParametro(commonService.getMaxId("id_parametro"));
        parameter.setIdAplicacion(applicationId);
        logger.debug("addParams " + parameter.toString());
        return parameterRepository.save(parameter);
    }

    /**
     * @param params Objeto de tipo Parameter que sera enviado a la capa de persistencia para ser actualizado.
     * @param id Identificador de la entidad Parameter.
     * @return Retorna una entidad de tipo Parameter con los datos actualizados de la capa de persistencia.
     */
    public Parameter updateParams(Parameter params, Integer id) {
        Optional<Parameter> paramsOptional = parameterRepository.findById(id, applicationId);
        if (!paramsOptional.isPresent())
            throw new EntityNotFound("No hay resultado por el valor: " + id);
        logger.info("updateParams " + params.toString());
        return parameterRepository.update(params);
    }

    /**
     * @param id Identificador de la entidad Parameter.
     */
    public void deleteParams(Integer id) {
        Optional<Parameter> params = parameterRepository.findById(id, applicationId);
        if (!params.isPresent())
            throw new EntityNotFound("No hay resultado por el valor: " + id);
        logger.info("deleteParams " + id);
        parameterRepository.delete(id, applicationId);
    }

    private ParameterDTO convertToDto(Parameter parameter) {
        return new ModelMapper().map(parameter, ParameterDTO.class);
    }

}
