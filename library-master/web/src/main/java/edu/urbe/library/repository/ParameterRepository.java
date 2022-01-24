/*
 * Copyright (C) Universidad Privada Dr Rafael Belloso Chacin.
 * Todos los derechos reservados.
 * La divulgación de este material está estrictamente prohibida a menos
 * que cuente con una autorización escrita por parte del propietario o
 * alguna de sus subsidiarias.
 */
package edu.urbe.library.repository;

import edu.urbe.library.entity.Parameter;
import edu.urbe.library.util.SQL;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Este repositorio ejecuta las operaciones CRUD de la entidad {@link Parameter}
 * @author David Soles
 */
@Repository
public class ParameterRepository extends BaseRepository implements CrudRepository<Parameter> {

    public ParameterRepository(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    /**
     * Este metodo no esta siendo utilizado.
     * @return Retorna una lista de entidades de tipo Parameter.
     */
    @Override
    public List<Parameter> findAll() {
        List<Parameter> parameterList = jdbcTemplate.query(SQL.FIND_ALL_PARAMETERS,
                new Object[]{},
                new BeanPropertyRowMapper<>(Parameter.class));
        return parameterList;
    }

    /**
     * @param applicationId Identificador de la aplicacion.
     * @return Retorna una lista de entidades de tipo Parameter.
     */
    public List<Parameter> findAll(int applicationId) {
        List<Parameter> parameterList = jdbcTemplate.query(SQL.FIND_ALL_PARAMETERS,
                new Object[]{applicationId},
                new BeanPropertyRowMapper<>(Parameter.class));
        return parameterList;
    }

    /**
     * Este metodo no esta siendo utilizado.
     * @param id Identificador de la entidad Parameter.
     * @return Retorna una entidad opcional de tipo Parameter.
     */
    @Override
    public Optional<Parameter> findById(Integer id) { return Optional.empty(); }

    /**
     * La llave primaria de la entidad Parameter es compuesta lo cual quiere decir que se requiere una combinacion
     * unica entre el <b>id</b> y el <b>idAplicacion</b>.
     * @param id Identificador de la entidad Parameter.
     * @param applicationId Identificador de la aplicacion a la que pertenece el parametro.
     * @return Retorna una entidad opcional de tipo Parameter.
     */
    public Optional<Parameter> findById(Integer id, int applicationId) {
        try {
            Parameter parameter = jdbcTemplate.queryForObject(SQL.FIND_PARAMETER_BY_ID,
                    new Object[]{id,applicationId},
                    new BeanPropertyRowMapper<>(Parameter.class));
            assert parameter != null;
            return Optional.of(parameter);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    /**
     * @param parameter Objeto de tipo Parameter con los datos que seran ingresados a la base de datos.
     * @return Retorna una entidad de tipo Parameter con los datos que fueron ingresados a la base de datos.
     */
    @Override
    public Parameter save(Parameter parameter) {
        jdbcTemplate.update(SQL.SAVE_PARAMETER, parameter.getIdParametro(), parameter.getDescripcionPar(),
                parameter.getValor(), parameter.getIdAcademico(), parameter.getIdUsuario(), parameter.getIdAplicacion());
        return parameter;
    }

    /**
     * @param parameter Objeto de tipo Parameter con los datos que seran actualizados en la base de datos.
     * @return Retorna una entidad de tipo Parameter con los datos actualizados.
     */
    @Override
    public Parameter update(Parameter parameter) {
        jdbcTemplate.update(SQL.UPDATE_PARAMETER, parameter.getDescripcionPar(),
                parameter.getValor(), parameter.getEstadoParametro(), parameter.getIdParametro(),
                parameter.getIdAplicacion());
        return parameter;
    }

    /**
     * Este metodo no esta siendo utilizado.
     * @param id Identificador de la entidad Parameter.
     */
    @Override
    public void delete(Integer id) { }

    /**
     * @param id Identificador de la entidad Parameter.
     * @param applicationId Identificador de la aplicacion a la que pertenece el parametro.
     */
    public void delete(Integer id, int applicationId) {
        jdbcTemplate.update(SQL.DELETE_PARAMETER, id, applicationId);
    }

}

