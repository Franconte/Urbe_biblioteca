/*
 * Copyright (C) Universidad Privada Dr Rafael Belloso Chacin.
 * Todos los derechos reservados.
 * La divulgación de este material está estrictamente prohibida a menos
 * que cuente con una autorización escrita por parte del propietario o
 * alguna de sus subsidiarias.
 */
package edu.urbe.library.resource;

import edu.urbe.library.entity.RestaurationType;
import edu.urbe.library.service.RestaurationTypeService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * Este recurso REST expone las diferentes operaciones que pueden ser llavadas a cabo con los tipos de restauracion ({@link RestaurationType}).
 * @author David Soles
 */
@RestController
public class RestaurationTypeResource {

    private RestaurationTypeService restaurationTypeService;

    public RestaurationTypeResource(RestaurationTypeService restaurationTypeService) {
        this.restaurationTypeService = restaurationTypeService;
    }

    /**
     * @return Retorna una lista de tipos de restauracion (RestaurationType).
     */
    @RequestMapping(method = RequestMethod.GET, value = "/restaurationType")
    public List<RestaurationType> findAll() {
        return restaurationTypeService.findAll();
    }

    /**
     * @param id Identificador de la entidad RestaurationType que se desea obtener.
     * @return Retorna una entidad opcional de tipo RestaurationType.
     */
    @RequestMapping(method = RequestMethod.GET, value = "/restaurationType/{id}")
    public Optional<RestaurationType> restaurationTypeByIdById(@PathVariable Integer id) {
        return restaurationTypeService.restaurationTypeById(id);
    }

    /**
     * Este recurso realiza validaciones de los datos que seran almacenados.
     * @param restaurationType Objeto de tipo RestaurationType que sera almacenado en la base de datos.
     * @return Retorna una entidad de tipo RestaurationType con los datos que se almacenaron en la base de datos.
     */
    @RequestMapping(method = RequestMethod.POST, value = "/restaurationType")
    public RestaurationType addRestaurationType(@Valid @RequestBody RestaurationType restaurationType) {
        return restaurationTypeService.addRestaurationType(restaurationType);
    }

    /**
     * Este recurso realiza validaciones de los datos que seran almacenados.
     * @param restaurationType Objeto de tipo RestaurationType que posee los datos que seran actualizados en la base de datos.
     * @param id Identificador de la entidad RestaurationType que sera actualizada.
     * @return Retorna una entidad de tipo RestaurationType con los datos actualizados.
     */
    @RequestMapping(method = RequestMethod.PUT, value = "/restaurationType/{id}")
    public RestaurationType updateRestaurationType(@RequestBody RestaurationType restaurationType, @PathVariable Integer id) {
        return restaurationTypeService.updateRestaurationType(restaurationType, id);
    }

    /**
     * @param id Identificador de la entidad RestaurationType que sera eliminada.
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "/restaurationType/{id}")
    public void deleteRestaurationType(@PathVariable Integer id) {
        restaurationTypeService.deleteRestaurationType(id);
    }

}