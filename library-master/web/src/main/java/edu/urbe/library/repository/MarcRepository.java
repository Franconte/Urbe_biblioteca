/*
 * Copyright (C) Universidad Privada Dr Rafael Belloso Chacin.
 * Todos los derechos reservados.
 * La divulgación de este material está estrictamente prohibida a menos
 * que cuente con una autorización escrita por parte del propietario o
 * alguna de sus subsidiarias.
 */
package edu.urbe.library.repository;

import edu.urbe.library.entity.Marc;
import edu.urbe.library.util.SQL;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Este repositorio ejecuta las operaciones CRUD de la entidad {@link Marc}
 * @author David Soles
 */
@Repository
public class MarcRepository extends BaseRepository implements CrudRepository<Marc> {

    public MarcRepository(@Qualifier("dburbeJdbcTemplate") JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    /**
     * @return Retorna una lista de etiquetas Marc.
     */
    @Override
    public List<Marc> findAll() {
        return jdbcTemplate.query(SQL.FIND_ALL_MARC,
                new Object[]{},
                new BeanPropertyRowMapper<>(Marc.class));
    }

    /**
     * Este metodo no esta siendo utilizado.
     * @param id Identificador de la entidad Marc.
     * @return Retorna un registro opcional de tipo marc.
     */
    @Override
    public Optional<Marc> findById(Integer id) { return Optional.empty(); }

    /**
     * @param marctag Identificador de la entidad Marc.
     * @return Retorna un registro opcional de tipo Marc.
     */
    public Optional<Marc> findById(String marctag) {
        try {
            Marc marc = jdbcTemplate.queryForObject(SQL.FIND_MARC_BY_ID,
                    new Object[]{marctag},
                    new BeanPropertyRowMapper<>(Marc.class));
            assert marc != null;
            return Optional.of(marc);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    /**
     * @param marc Objeto de tipo Marc que contiene los datos que seran ingresados a la base de datos.
     *             La entidad Marc no utiliza como llave primaria una columna auto incremental.
     * @return Retorna una entidad Marc con los datos recien creados.
     */
    @Override
    public Marc save(Marc marc) {
        jdbcTemplate.update(SQL.SAVE_MARC, marc.getNombre(), marc.getSubindices(), marc.getUso(), marc.getMarctag(),
                marc.getEtiqueta(), marc.getAyudaMarctag(), marc.getIdAcademico(), marc.getIdUsuario(),
                marc.getEtiquetaWeb());
        return marc;
    }

    /**
     * @param marc Objeto de tipo Marc que contiene los datos que seran actualizados.
     * @return Retorna una entidad Marc con los datos actualizados.
     */
    @Override
    public Marc update(Marc marc) {
        jdbcTemplate.update(SQL.UPDATE_MARC, marc.getNombre(), marc.getSubindices(), marc.getUso(),
                marc.getEtiqueta(), marc.getAyudaMarctag(), marc.getEtiquetaWeb(), marc.getMarctag());
        return findById(marc.getMarctag()).get();
    }

    /**
     * Este metodo no esta siendo utilizado.
     * @param id Identificador de la entidad Marc.
     */
    @Override
    public void delete(Integer id) { }

    /**
     * @param marctag Identificador de la entidad Marc.
     */
    public void delete(String marctag) {
        jdbcTemplate.update(SQL.DELETE_MARC, marctag);
    }

}
