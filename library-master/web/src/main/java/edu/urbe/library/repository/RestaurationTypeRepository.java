/*
 * Copyright (C) Universidad Privada Dr Rafael Belloso Chacin.
 * Todos los derechos reservados.
 * La divulgación de este material está estrictamente prohibida a menos
 * que cuente con una autorización escrita por parte del propietario o
 * alguna de sus subsidiarias.
 */
package edu.urbe.library.repository;

import edu.urbe.library.entity.RestaurationType;
import edu.urbe.library.util.SQL;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Este repositorio ejecuta las operaciones CRUD de la entidad {@link RestaurationType}.
 * @author David Soles
 */
@Repository
public class RestaurationTypeRepository extends BaseRepository implements CrudRepository<RestaurationType> {

    public RestaurationTypeRepository(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    /**
     * @return Retorna una lista de tipos de restauracion.
     */
    @Override
    public List<RestaurationType> findAll() {
        List<RestaurationType> restaurationTypeList = jdbcTemplate.query(SQL.FIND_ALL_RESTAURATION_TYPE,
                new Object[]{},
                new BeanPropertyRowMapper<>(RestaurationType.class));
        return restaurationTypeList;
    }

    /**
     * @param id Identificador de una entidad RestaurationType.
     * @return Retorna una entidad de tipo RestaurationType.
     */
    @Override
    public Optional<RestaurationType> findById(Integer id) {
        try {
            RestaurationType restaurationType = jdbcTemplate.queryForObject(SQL.FIND_RESTAURATION_TYPE_BY_ID,
                    new Object[]{id},
                    new BeanPropertyRowMapper<>(RestaurationType.class));
            assert restaurationType != null;
            return Optional.of(restaurationType);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    /**
     * @param restaurationType Objeto de tipo RestaurationType con los datos que seran almacenados en la base de datos.
     * @return Retorna una entidad de tipo RestaurationType con los datos almacenados en la base de datos.
     */
    @Override
    public RestaurationType save(RestaurationType restaurationType) {
        jdbcTemplate.update(SQL.SAVE_RESTAURATION_TYPE, restaurationType.getIdTipoRestauracion(),
                restaurationType.getTipoRestauracion(), restaurationType.getIdAcademico(),
                restaurationType.getIdUsuario());
        return restaurationType;
    }

    /**
     * @param restaurationType Objeto de tipo RestaurationType con los datos que desea actualizar en la base de datos.
     * @return Retorna una entidad de tipo RestaurationType con los datos actualizados.
     */
    @Override
    public RestaurationType update(RestaurationType restaurationType) {
        jdbcTemplate.update(SQL.UPDATE_RESTAURATION_TYPE, restaurationType.getTipoRestauracion(),
                restaurationType.getIdTipoRestauracion());
        return restaurationType;
    }

    /**
     * @param id Identificador de la entidad RestaurationType que desea eliminar.
     */
    @Override
    public void delete(Integer id) {
        jdbcTemplate.update(SQL.DELETE_RESTAURATION_TYPE, id);
    }

}
