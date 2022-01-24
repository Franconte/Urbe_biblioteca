/*
 * Copyright (C) Universidad Privada Dr Rafael Belloso Chacin.
 * Todos los derechos reservados.
 * La divulgación de este material está estrictamente prohibida a menos
 * que cuente con una autorización escrita por parte del propietario o
 * alguna de sus subsidiarias.
 */
package edu.urbe.library.repository;

import edu.urbe.library.entity.Catalog;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author David Soles
 */
@Repository
public class CatalogRepository extends BaseRepository implements CrudRepository<Catalog> {

    public CatalogRepository(@Qualifier("dburbeJdbcTemplate") JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    /**
     * Este metodo no se utiliza.
     * @return Retorna una lista con entidades catalogo.
     */
    @Override
    public List<Catalog> findAll() {
        return null;
    }

    /**
     * Este método no se utiliza.
     * @param id Identificador de un registro de catalogo.
     * @return Retorna una entidad opcional de catalogo a partir de su identificador.
     */
    @Override
    public Optional<Catalog> findById(Integer id) {
        return Optional.empty();
    }

    /**
     * @param idCota Identificador de una lista de elementos de tipo catalogo.
     * @return Retorna una lista de catalogos a partir de su idCota.
     */
    public List<Catalog> findByIdCota(Integer idCota) {
        try {
            return jdbcTemplate.query(""
                            + "SELECT id, "
                            + "       id_mtb, "
                            + "       marctag, "
                            + "       id_cota, "
                            + "       datos, "
                            + "       fecha_crea, "
                            + "       fecha_ultmod, "
                            + "       COALESCE(id_academico, 1) AS id_academico, "
                            + "       COALESCE(id_usuario, 1)   AS id_usuario "
                            + "  FROM catalogo "
                            + " WHERE id_cota = ?",
                    new Object[]{idCota},
                    new BeanPropertyRowMapper<>(Catalog.class));
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    /**
     * @param idCotas Identificadores de una lista de elementos de tipo catalogo.
     * @return Retorna una lista de catalogos a partir de su idCota.
     */
    public List<Catalog> findByIdCota(List<Integer> idCotas) {
        Map<String, List> parameters = Collections.singletonMap("ids", idCotas);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate.getDataSource());
        try {
            return template.query(""
                            + "SELECT id, "
                            + "       id_mtb, "
                            + "       marctag, "
                            + "       id_cota, "
                            + "       datos, "
                            + "       fecha_crea, "
                            + "       fecha_ultmod, "
                            + "       COALESCE(id_academico, 1) AS id_academico, "
                            + "       COALESCE(id_usuario, 1)   AS id_usuario "
                            + "  FROM catalogo "
                            + " WHERE id_cota IN (:ids) AND marctag = '245'",
                    parameters,
                    new BeanPropertyRowMapper<>(Catalog.class));
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    /**
     * @param catalog Objeto de tipo catalogo que sera almacenado en la base de datos.
     * @return Retorna una entidad de tipo catalago.
     */
    @Override
    public Catalog save(Catalog catalog) {
        jdbcTemplate.update(""
                        + "INSERT INTO catalogo "
                        + "             (id_mtb, "
                        + "             marctag, "
                        + "             id_cota, "
                        + "             datos, "
                        + "             fecha_crea, "
                        + "             fecha_ultmod, "
                        + "             id_academico, "
                        + "             id_usuario) "
                        + "VALUES (?, ?, ?, ?, getdate(), getdate(), ?, ?)",
                catalog.getIdMtb(), catalog.getMarctag(), catalog.getIdCota(), catalog.getDatos(),
                catalog.getIdAcademico(), catalog.getIdUsuario());
        return catalog;
    }

    /**
     * @param catalogs Lista de objetos de tipo catalogo que seran almacenados en la base de datos.
     * @return Retorna una lista con entidades de tipo catalogo.
     */
    public List<Catalog> save(List<Catalog> catalogs) {
        for (Catalog catalog : catalogs) {
            jdbcTemplate.update(""
                            + "INSERT INTO catalogo "
                            + "             (id_mtb, "
                            + "             marctag, "
                            + "             id_cota, "
                            + "             datos, "
                            + "             fecha_crea, "
                            + "             fecha_ultmod, "
                            + "             id_academico, "
                            + "             id_usuario) "
                            + "VALUES (?, ?, ?, ?, getdate(), getdate(), ?, ?)",
                    catalog.getIdMtb(), catalog.getMarctag(), catalog.getIdCota(), catalog.getDatos(),
                    catalog.getIdAcademico(), catalog.getIdUsuario());
        }
        return findByIdCota(catalogs.get(0).getIdCota());
    }

    /**
     * @param catalog Objeto de tipo catalogo que será actualizado en la base de datos.
     * @return Retorna una entidad de tipo catalogo.
     */
    @Override
    public Catalog update(Catalog catalog) {
        jdbcTemplate.update("UPDATE catalogo SET datos = ?, fecha_ultmod = getdate() WHERE id = ?",
                catalog.getDatos(), catalog.getId());
        return catalog;
    }

    /**
     * @param catalogs Lista de objetos de tipo catalogo que seran actualizados en la base de datos.
     * @return Retorna una lista con entidades de tipo catalogo.
     */
    public List<Catalog> update(List<Catalog> catalogs) {
        for (Catalog catalog : catalogs) {
            jdbcTemplate.update("UPDATE catalogo SET datos = ?, fecha_ultmod = getdate() WHERE id = ?",
                    catalog.getDatos(), catalog.getId());
        }
        return findByIdCota(catalogs.get(0).getIdCota());
    }

    /**
     * @param idCota Identificador de una lista de elementos de tipo catalogo.
     */
    @Override
    public void delete(Integer idCota) {
        jdbcTemplate.update("DELETE FROM catalogo WHERE id_cota = ?", idCota);
    }

    /**
     * @param idCota Identificador de una lista de elementos de tipo catalogo.
     * @param idCatalogo Identificador de un registro de catalogo.
     */
    public void delete(Integer idCota, Integer idCatalogo) {
        jdbcTemplate.update("DELETE FROM catalogo WHERE id_cota = ? AND id = ?", idCota, idCatalogo);
    }

}
