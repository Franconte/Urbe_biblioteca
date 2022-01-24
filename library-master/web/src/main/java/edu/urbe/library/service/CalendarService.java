/*
 * Copyright (C) Universidad Privada Dr Rafael Belloso Chacin.
 * Todos los derechos reservados.
 * La divulgación de este material está estrictamente prohibida a menos
 * que cuente con una autorización escrita por parte del propietario o
 * alguna de sus subsidiarias.
 */
package edu.urbe.library.service;

import edu.urbe.library.entity.Calendar;
import edu.urbe.library.exception.EntityNotFound;
import edu.urbe.library.repository.CalendarRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Este servicio contiene toda la logica relacionada con los días del calendario.
 * @author David Soles
 */
@Service
public class CalendarService {

    private static final Logger logger = LoggerFactory.getLogger(CalendarService.class);

    private CommonService commonService;
    private CalendarRepository calendarRepository;

    public CalendarService(CommonService commonService, CalendarRepository calendarRepository) {
        this.commonService = commonService;
        this.calendarRepository = calendarRepository;
    }

    /**
     * @return Lista de días calendario del mes actual según la fecha de consulta.
     */
    public List<Calendar> findByCurrentMonth() {
        List<Calendar> calendars = calendarRepository.findByCurrentMonth();
        logger.debug(calendars.toString());
        return calendars;
    }

    /**
     * @param mes Mes a consultar.
     * @return Lista de días calendario según mes consultado.
     */
    public List<Calendar> findByMonth(Integer mes) {
        List<Calendar> calendar = calendarRepository.findByMonth(mes);
        if (calendar.isEmpty())
            throw new EntityNotFound("No se encontraron registros para el mes " + mes);
        return calendar;
    }

    /**
     * @param id Identificador de un calendario.
     * @return Retorna una entidad opcional de tipo calendario.
     */
    public Optional<Calendar> calendarById(Integer id) {
        Optional<Calendar> calendar = calendarRepository.findById(id);
        if (!calendar.isPresent())
            throw new EntityNotFound("No hay resultado por el valor: " + id);
        return calendar;
    }

    /**
     * @param calendar Objeto de tipo calendario con los datos que seran actualizados.
     * @return Entidad de tipo calendario.
     */
    public Calendar addCalendar(Calendar calendar) {
        logger.debug("POST -> /calendar -> " + calendar);
        calendar.setIdCalendario(commonService.getMaxId("id_calendario"));
        return calendarRepository.save(calendar);
    }

    /**
     * @param calendar Objeto de tipo calendario con los datos que seran actualizados.
     * @param id Identificador del dia calendario que sera actualizado.
     * @return Entidad con los datos de un dia calendario.
     */
    public Calendar updateCalendar(Calendar calendar, Integer id) {
        Optional<Calendar> calendarOptional = calendarRepository.findById(id);
        if (!calendarOptional.isPresent())
            throw new EntityNotFound("No hay resultado por el valor: " + id);
        return calendarRepository.update(calendar);
    }

    /**
     * @param id Identificador del dia calendario que sera eliminado.
     */
    public void deleteCalendar(Integer id) {
        Optional<Calendar> calendar = calendarRepository.findById(id);
        if (!calendar.isPresent())
            throw new EntityNotFound("No hay resultado por el valor: " + id);
        calendarRepository.delete(id);
    }

}
