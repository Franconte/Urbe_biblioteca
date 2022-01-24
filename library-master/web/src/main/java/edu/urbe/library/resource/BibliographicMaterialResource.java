/*
 * Copyright (C) Universidad Privada Dr Rafael Belloso Chacin.
 * Todos los derechos reservados.
 * La divulgación de este material está estrictamente prohibida a menos
 * que cuente con una autorización escrita por parte del propietario o
 * alguna de sus subsidiarias.
 */
package edu.urbe.library.resource;

import edu.urbe.library.dto.BibliographicMaterialDTO;
import edu.urbe.library.entity.BibliographicMaterial;
import edu.urbe.library.service.BibliographicMaterialService;
import edu.urbe.library.validator.BibliographicMaterialValidator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Este recurso REST expone las diferentes operaciones que pueden ser llavadas a cabo con el material bibliografico.
 * @author David Soles
 */
@RestController
public class BibliographicMaterialResource {

    private BibliographicMaterialService bibliographicMaterialService;
    private BibliographicMaterialValidator bibliographicMaterialValidator;

    public BibliographicMaterialResource(BibliographicMaterialService bibliographicMaterialService, BibliographicMaterialValidator bibliographicMaterialValidator) {
        this.bibliographicMaterialService = bibliographicMaterialService;
        this.bibliographicMaterialValidator = bibliographicMaterialValidator;
    }

    /**
     * @param binder Vincula los datos enviados por un cliente con un validador especifico.
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(bibliographicMaterialValidator);
    }

    /**
     * @return Retorna una lista con el material bibliografico disponible y en estado <u>Activo</u>.
     */
    @RequestMapping(method = RequestMethod.GET, value = "/bibliography")
    public List<BibliographicMaterialDTO> findAll() {
        return bibliographicMaterialService.findAll();
    }

    /**
     * @param id Identificador del material bibliografico que se desea obtener.
     * @return Retorna una entidad opcional de tipo material bibliografico.
     */
    @RequestMapping(method = RequestMethod.GET, value = "/bibliography/{id}")
    public Optional<BibliographicMaterial> bibliographyById(@PathVariable Integer id) {
        return bibliographicMaterialService.bibliographicMaterialById(id);
    }

    /**
     * @param bibliography Objeto de tipo material bibliografico que contiene los datos de la entidad que se desea crear. Se realizan
     *                     validaciones debido a que algunas propiedades de la clase no pueden ser nulas.
     * @return Retorna una entidad de tipo material bibliografico con los datos del registro recien creado.
     */
    @RequestMapping(method = RequestMethod.POST, value = "/bibliography")
    public BibliographicMaterial addBibliography(@Validated @RequestBody BibliographicMaterial bibliography) {
        return bibliographicMaterialService.addBibliographicMaterial(bibliography);
    }

    /**
     * @param bibliography Objeto de tipo material bibliografico que contiene los datos que van a ser actualizados. Se realizan
     *                     validaciones debido a que algunas propiedades de la clase no pueden ser nulas.
     * @param id Identificador de la entidad material bibliografico que se desea actualizar.
     * @return Retorna una entidad de tipo material bibliografico con los datos actualizados.
     */
    @RequestMapping(method = RequestMethod.PUT, value = "/bibliography/{id}")
    public BibliographicMaterial updateBibliography(@Validated @RequestBody BibliographicMaterial bibliography, @PathVariable Integer id) {
        return bibliographicMaterialService.updateBibliographicMaterial(bibliography, id);
    }

    /**
     * @param id Identificador de la entidad material bibliografico que se desea eliminar.
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "/bibliography/{id}")
    public void deleteBibliography(@PathVariable Integer id) {
        bibliographicMaterialService.deleteBibliographicMaterial(id);
    }
}
