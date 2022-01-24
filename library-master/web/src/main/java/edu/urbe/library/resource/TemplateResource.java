/*
 * Copyright (C) Universidad Privada Dr Rafael Belloso Chacin.
 * Todos los derechos reservados.
 * La divulgación de este material está estrictamente prohibida a menos
 * que cuente con una autorización escrita por parte del propietario o
 * alguna de sus subsidiarias.
 */
package edu.urbe.library.resource;

import edu.urbe.library.dto.TemplateDTO;
import edu.urbe.library.entity.Marc;
import edu.urbe.library.entity.Template;
import edu.urbe.library.entity.TemplateMarc;
import edu.urbe.library.service.TemplateService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Este recurso REST expone las diferentes operaciones que pueden ser llavadas a cabo con las plantillas ({@link Template}).
 * @author David Soles
 */
@RestController
public class TemplateResource {

    private TemplateService templateService;

    public TemplateResource(TemplateService templateService) {
        this.templateService = templateService;
    }

    /**
     * @return Retorna una lista de plantillas (Template).
     */
    @RequestMapping(method = RequestMethod.GET, value = "/template")
    public List<TemplateDTO> findAll() {
        return templateService.findAll();
    }

    /**
     * @param idMtb Identificador del tipo de material bibliografico ({@link edu.urbe.library.entity.BibliographicMaterial}) asociado a la plantilla.
     * @return Retorna una lista de plantillas {@link Template} a partir de un tipo de material bibliografico {@link edu.urbe.library.entity.BibliographicMaterial}.
     */
    @RequestMapping(method = RequestMethod.GET, value = "/template/mtb/{idMtb}")
    public List<TemplateDTO> findAllByIdMtb(@PathVariable Integer idMtb) {
        return templateService.findAllByIdMtb(idMtb);
    }

    /**
     * @param id Identificador de la entidad Template.
     * @return Retorna una entidad opcional de tipo Template.
     */
    @RequestMapping(method = RequestMethod.GET, value = "/template/{id}")
    public Optional<Template> templateById(@PathVariable Integer id) {
        return templateService.templateById(id);
    }

    /**
     * @param template Objeto de tipo Template con los datos que seran ingresados en la base de datos.
     * @return Retorna una entidad de tipo Template con los datos almacenados.
     */
    @RequestMapping(method = RequestMethod.POST, value = "/template")
    public Template addTemplate(@Validated @RequestBody Template template) {
        return templateService.addTemplate(template);
    }

    /**
     * @param template Objeto de tipo Template con los datos que se actualizaran en la base de datos.
     * @param id Identificador de la entidad Template que se actualizara en la base de datos.
     * @return Retorna una entidad de tipo Template con los datos actualizados.
     */
    @RequestMapping(method = RequestMethod.PUT, value = "/template/{id}")
    public Template updateTemplate(@RequestBody Template template, @PathVariable Integer id) {
        return templateService.updateTemplate(template, id);
    }

    /**
     * @param id Identificador de la entidad Template que se eliminara.
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "/template/{id}")
    public void deleteTemplate(@PathVariable Integer id) {
        templateService.deleteTemplate(id);
    }

    /**
     * @param id Identificador de la entidad Template.
     * @return Retorna una lista de etiquetas Marc asociadas a una plantilla determinada.
     */
    @RequestMapping(method = RequestMethod.GET, value = "/template/{id}/marc")
    public List<TemplateMarc> findMarcTemplate(@PathVariable Integer id) {
        return templateService.findMarcByTemplateId(id);
    }

    /**
     * @param id Identificador de la entidad Template.
     * @return Retorna una lista de etiquetas Marc asociadas a una plantilla determinada.
     */
    @RequestMapping(method = RequestMethod.POST, value = "/template/{id}/marc")
    public List<TemplateMarc> saveMarcTemplate(@PathVariable Integer id, @RequestBody List<TemplateMarc> marcs) {
        return templateService.saveMarcByTemplateId(id, marcs);
    }

    /**
     * @param id Identificador de la entidad Template.
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "/template/{id}/marc")
    public void deleteMarcTemplate(@PathVariable Integer id, @RequestBody TemplateMarc marc) {
        templateService.deleteMarcByTemplateId(id, marc);
    }

}
