/*
 * Copyright (C) Universidad Privada Dr Rafael Belloso Chacin.
 * Todos los derechos reservados.
 * La divulgación de este material está estrictamente prohibida a menos
 * que cuente con una autorización escrita por parte del propietario o
 * alguna de sus subsidiarias.
 */
package edu.urbe.library.resource;

import edu.urbe.library.dto.ParameterDTO;
import edu.urbe.library.entity.Parameter;
import edu.urbe.library.service.ParameterService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Este recurso REST expone las diferentes operaciones que pueden ser llavadas a cabo con los parametros de biblioteca.
 * @author David Soles
 */
@RestController
public class ParameterResource {

    private ParameterService parameterService;

    public ParameterResource(ParameterService parameterService) {
        this.parameterService = parameterService;
    }

    /**
     * @return Retorna una lista de Parametros.
     */
    @RequestMapping(method = RequestMethod.GET, value = "/parameter")
    public List<ParameterDTO> findAll() {
        return parameterService.findAll();
    }

    /**
     * @param id Identificador del parametro que desea obtener. Internamente se incluye el identificador de la aplicacion.
     * @return Retorna una entidad opcional de tipo Parameter.
     */
    @RequestMapping(method = RequestMethod.GET, value = "/parameter/{id}")
    public Optional<Parameter> paramsById(@PathVariable Integer id) {
        return parameterService.findById(id);
    }

    /**
     * @param params Objeto de tipo Parameter con los datos que seran almacenados en la base de datos.
     * @return Retorna una entidad de tipo Parameter con los datos almacenados en la base de datos.
     */
    @RequestMapping(method = RequestMethod.POST, value = "/parameter")
    public Parameter addParams(@Validated @RequestBody Parameter params) {
        return parameterService.addParams(params);
    }

    /**
     * @param params Objeto de tipo Parameter con los datos que sera actualizados en la base de datos.
     * @param id Identificador del parametro que se actualizara. Internamente se incluye el identificador de la aplicacion.
     * @return Retorna una entidad de tipo Parameter con los datos actualizados.
     */
    @RequestMapping(method = RequestMethod.PUT, value = "/parameter/{id}")
    public Parameter updateParams(@RequestBody Parameter params, @PathVariable Integer id) {
        return parameterService.updateParams(params, id);
    }

    /**
     * @param id Identificador de la entidad Parameter que desea eliminar. Internamente se incluye el identificador de la aplicacion.
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "/parameter/{id}")
    public void deleteParams(@PathVariable Integer id) {
        parameterService.deleteParams(id);
    }

}
