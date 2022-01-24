/*
 * Copyright (C) Universidad Privada Dr Rafael Belloso Chacin.
 * Todos los derechos reservados.
 * La divulgación de este material está estrictamente prohibida a menos
 * que cuente con una autorización escrita por parte del propietario o
 * alguna de sus subsidiarias.
 */
package edu.urbe.library.service;

import edu.urbe.library.dto.TemplateDTO;
import edu.urbe.library.entity.BibliographicMaterial;
import edu.urbe.library.entity.Template;
import edu.urbe.library.entity.TemplateMarc;
import edu.urbe.library.exception.EntityNotFound;
import edu.urbe.library.repository.TemplateRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Este servicio contiene toda la logica relacionada con las plantillas {@link Template}.
 * @author David Soles
 */
@Service
public class TemplateService {

    private static final Logger logger = LoggerFactory.getLogger(TemplateService.class);

    private CommonService commonService;
    private TemplateRepository templateRepository;

    public TemplateService(CommonService commonService, TemplateRepository templateRepository) {
        this.commonService = commonService;
        this.templateRepository = templateRepository;
    }

    /**
     * @return Retorna una lista de plantillas.
     */
    public List<TemplateDTO> findAll() {
        logger.info("findAll");
        List<Template> templateList = (List<Template>) templateRepository.findAll();
        return templateList.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    /**
     * @param idMtb Identificador del tipo de material bibliografico ({@link BibliographicMaterial}).
     * @return Retorna una lista de plantillas proyectadas hacia {@link TemplateDTO}.
     */
    public List<TemplateDTO> findAllByIdMtb(Integer idMtb) {
        logger.info("findAllByIdMtb " + idMtb);
        List<Template> templateList = (List<Template>) templateRepository.findAllByIdMtb(idMtb);
        return templateList.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    /**
     * @param id Identificador de la entidad plantilla.
     * @return Retorna una entidad opcional de tipo plantilla a partir del identificador proporcionado.
     */
    public Optional<Template> templateById(Integer id) {
        logger.debug("templateById " + id);
        Optional<Template> templateOptional = templateRepository.findById(id);
        logger.debug("templateOptional " + templateOptional.toString());
        if (!templateOptional.isPresent()) {
            throw new EntityNotFound("No se encontro un resultado con el valor: " + id);
        }
        return templateOptional;
    }

    /**
     * @param template Objeto de tipo Template con los datos que seran almacenados en la base de datos.
     * @return Retorna una entidad de tipo Template con los datos que fueron almacenados en la base de datos.
     */
    public Template addTemplate(Template template) {
        logger.debug("addTemplate " + template.toString());
        template.setIdPlantilla(commonService.getMaxId("id_plantilla"));
        return templateRepository.save(template);
    }

    /**
     * @param template Objeto de tipo Template con los datos que seran actualizados en la base de datos.
     * @param id Identificador de la entidad Template que sera actualizada.
     * @return Retorna una entidad de tipo Template con los datos actualizados.
     */
    public Template updateTemplate(Template template, Integer id) {
        logger.info("updateTemplate " + id + "\n" + template.toString());
        Optional<Template> templateOptional = templateRepository.findById(id);
        if (!templateOptional.isPresent()) {
            throw new EntityNotFound("No hay resultado por el valor: " + id);
        }
        return templateRepository.update(template);
    }

    /**
     * @param id Identificador de la plantilla que sera eliminada.
     */
    public void deleteTemplate(Integer id) {
        Optional<Template> templateOptional = templateRepository.findById(id);
        if (!templateOptional.isPresent())
            throw new EntityNotFound("No hay resultado por el valor: " + id);
        templateRepository.delete(id);
    }

    /**
     * @param id Identificador de la plantilla.
     * @return Retorna una lista de etiquetas Marc asociadas a una plantilla.
     */
    public List<TemplateMarc> findMarcByTemplateId(Integer id) {
        return templateRepository.findMarcByTemplateId(id);
    }

    /**
     * @param id Identificador de la plantilla.
     * @param marcs Arreglo de etiquetas Marc asociadas a una plantilla que seran almacenadas en la base de datos.
     * @return Retorna una lista de etiquetas Marc asociadas a una plantilla.
     */
    @Transactional
    public List<TemplateMarc> saveMarcByTemplateId(Integer id, List<TemplateMarc> marcs) {
        try {
            return templateRepository.saveMarcByTemplateId(id, marcs);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalArgumentException("Etiqueta Marc Inválida");
        }
    }

    /**
     * @param id Identificador de la plantilla.
     * @param marc Etiqueta Marc que sera desasociada de la plantilla.
     */
    public void deleteMarcByTemplateId(Integer id, TemplateMarc marc) {
        templateRepository.deleteMarcByTemplateId(id, marc);
    }

    /**
     * @param template Entidad de tipo Template.
     * @return Retorna un TemplateDTO proyectado a partir de una entidad Template.
     */
    private TemplateDTO convertToDto(Template template) {
        return new ModelMapper().map(template, TemplateDTO.class);
    }

}
