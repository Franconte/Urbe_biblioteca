/*
 * Copyright (C) Universidad Privada Dr Rafael Belloso Chacin.
 * Todos los derechos reservados.
 * La divulgación de este material está estrictamente prohibida a menos
 * que cuente con una autorización escrita por parte del propietario o
 * alguna de sus subsidiarias.
 */
package edu.urbe.library.repository;

import edu.urbe.library.entity.Calendar;
import edu.urbe.library.util.SQL;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Este repositorio ejecuta las operaciones CRUD de la entidad {@link Calendar}
 * @author David Soles
 */
@Repository
public class CalendarRepository extends BaseRepository implements CrudRepository<Calendar> {

    public CalendarRepository(@Qualifier("dburbeJdbcTemplate") JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    /**
     * @return Retorna una lista de dias calendario.
     */
    @Override
    public List<Calendar> findAll() {
        List<Calendar> calendarList = jdbcTemplate.query(SQL.FIND_ALL_CALENDAR,
                new Object[]{},
                new BeanPropertyRowMapper<>(Calendar.class));
        return calendarList;
    }

    /**
     * @param id Identificador de la entidad calendario.
     * @return Retorna una entidad opcional de tipo calendario a partir del identificador proporcionado.
     */
    @Override
    public Optional<Calendar> findById(Integer id) {
        try {
            Calendar calendar = jdbcTemplate.queryForObject(SQL.FIND_CALENDAR_BY_ID,
                    new Object[]{id},
                    new BeanPropertyRowMapper<>(Calendar.class));
            assert calendar != null;
            return Optional.of(calendar);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    /**
     * @param calendar Objeto de tipo calendario que contiene los datos que seran ingresados a la base de datos.
     * @return Retorna una entidad de tipo calendario con los datos del registro recien creado.
     */
    @Override
    public Calendar save(Calendar calendar) {
    	jdbcTemplate.update(SQL.SAVE_CALENDAR, calendar.getIdCalendario(), calendar.getFechaGracia(),
				calendar.getDescFecha(), calendar.getFijoFestivo(), calendar.getIdAcademico(), calendar.getIdUsuario());
        return calendar;
    }

    /**
     * @param calendar Objeto de tipo calendario que contiene los datos que seran actualizados en la base de datos.
     * @return Retorna una entidad de tipo calendario con los datos actualizados.
     */
    @Override
    public Calendar update(Calendar calendar) {
		jdbcTemplate.update(SQL.UPDATE_CALENDAR, calendar.getFechaGracia(),
				calendar.getDescFecha(), calendar.getFijoFestivo(), calendar.getIdCalendario());
        return calendar;
    }

    /**
     * @param id Identificador del dia calendario que desea eliminar.
     */
    @Override
    public void delete(Integer id) {
		jdbcTemplate.update(SQL.DELETE_CALENDAR, id);
    }

    /**
     * @param month Mes que desea consultar.
     * @return Retorna una lista de dias calendario en funcion del parametro (mes) enviado por el usuario.
     */
    public List<Calendar> findByMonth(Integer month) {
		List<Calendar> calendarList = jdbcTemplate.query(SQL.FIND_BY_MONTH,
				new Object[]{month},
				new BeanPropertyRowMapper<>(Calendar.class));
		return calendarList;
    }

    /**
     * @return Retorna una lista de dias calendario tomando en cuenta el mes de la fecha de consulta.
     */
    public List<Calendar> findByCurrentMonth() {
		List<Calendar> calendarList = jdbcTemplate.query(SQL.FIND_BY_CURRENT_MONTH,
				new Object[]{},
				new BeanPropertyRowMapper<>(Calendar.class));
		return calendarList;
    }

}
