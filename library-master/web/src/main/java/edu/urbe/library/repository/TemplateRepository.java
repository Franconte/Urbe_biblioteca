/*
 * Copyright (C) Universidad Privada Dr Rafael Belloso Chacin.
 * Todos los derechos reservados.
 * La divulgación de este material está estrictamente prohibida a menos
 * que cuente con una autorización escrita por parte del propietario o
 * alguna de sus subsidiarias.
 */
package edu.urbe.library.repository;

import edu.urbe.library.entity.Template;
import edu.urbe.library.entity.TemplateMarc;
import edu.urbe.library.util.SQL;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Este repositorio ejecuta las operaciones CRUD de la entidad {@link Template}.
 * @author David Soles
 */
@Repository
public class TemplateRepository extends BaseRepository implements CrudRepository<Template> {

    public TemplateRepository(@Qualifier("dburbeJdbcTemplate") JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    /**
     * @return Retorna una lista de plantillas.
     */
    @Override
    public List<Template> findAll() {
        List<Template> templateList = jdbcTemplate.query(SQL.FIND_ALL_TEMPLATES,
                new Object[]{},
                new BeanPropertyRowMapper<>(Template.class));
        return templateList;
    }

    /**
     * @param id Identificador de una entidad Template.
     * @return Retorna una entidad opcional de tipo Template.
     */
    @Override
    public Optional<Template> findById(Integer id) {
        try {
            Template template = jdbcTemplate.queryForObject(SQL.FIND_TEMPLATE_BY_ID,
                    new Object[]{id},
                    new BeanPropertyRowMapper<>(Template.class));
            assert template != null;
            return Optional.of(template);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    /**
     * @param template Objeto de tipo Template con los datos que seran almacenados en la base de datos.
     * @return Retorna una entidad de tipo Template con los datos almacenados en la base de datos.
     */
    @Override
    public Template save(Template template) {
        jdbcTemplate.update(SQL.SAVE_TEMPLATE, template.getIdPlantilla(), template.getIdMtb(), template.getPlantilla(),
                template.getIdAcademico(), template.getIdUsuario());
        return template;
    }

    /**
     * @param template Objeto de tipo Template con los datos que seran actualizados en la base de datos.
     * @return Retorna una entidad de tipo Template con los datos que fueron almacenados en la base de datos.
     */
    @Override
    public Template update(Template template) {
        jdbcTemplate.update(SQL.UPDATE_TEMPLATE, template.getIdMtb(), template.getPlantilla(), template.getIdPlantilla());
        return template;
    }

    /**
     * @param id Identificador de la entidad Template que sera eliminada.
     */
    @Override
    public void delete(Integer id) {
        jdbcTemplate.update(SQL.DELETE_TEMPLATE, id);
    }

    /**
     * @param idMtb Identificador de la entidad {@link edu.urbe.library.entity.BibliographicMaterial}.
     * @return Retorna una lista de plantillas a partir de un tipo de material bibliografico.
     */
    public List<Template> findAllByIdMtb(Integer idMtb) {
        List<Template> templateList = jdbcTemplate.query(SQL.FIND_ALL_TEMPLATES_BY_ID_MTB,
                new Object[]{idMtb},
                new BeanPropertyRowMapper<>(Template.class));
        return templateList;
    }

    /**
     * @param id Identificador de la plantilla.
     * @return Retorna una lista de etiquetas Marc asociadas a una plantilla.
     */
    public List<TemplateMarc> findMarcByTemplateId(Integer id) {
        List<TemplateMarc> marcList = jdbcTemplate.query("SELECT id_plantilla, marctag FROM plantilla_campo WHERE id_plantilla = ?",
                new Object[]{id},
                new BeanPropertyRowMapper<>(TemplateMarc.class));
        return marcList;
    }

    /**
     * @param id Identificador de la plantilla.
     * @param marcs Arreglo de etiquetas Marc asociadas a una plantilla que seran almacenadas en la base de datos.
     * @return Retorna una lista de etiquetas Marc asociadas a una plantilla.
     */
    public List<TemplateMarc> saveMarcByTemplateId(Integer id, List<TemplateMarc> marcs) {
        for (TemplateMarc marc : marcs) {
            jdbcTemplate.update("INSERT INTO plantilla_campo (id_plantilla, marctag) VALUES (?,?)", id, marc.getMarctag());
        }
        return findMarcByTemplateId(id);
    }

    /**
     * @param id Identificador de la plantilla.
     * @param marc Etiqueta Marc que sera desasociada de la plantilla.
     */
    public void deleteMarcByTemplateId(Integer id, TemplateMarc marc) {
        jdbcTemplate.update("DELETE FROM plantilla_campo WHERE id_plantilla = ? AND marctag = ?", id, marc.getMarctag());
    }

}
