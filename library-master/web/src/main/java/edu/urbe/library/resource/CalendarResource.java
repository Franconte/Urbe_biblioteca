/*
 * Copyright (C) Universidad Privada Dr Rafael Belloso Chacin.
 * Todos los derechos reservados.
 * La divulgación de este material está estrictamente prohibida a menos
 * que cuente con una autorización escrita por parte del propietario o
 * alguna de sus subsidiarias.
 */
package edu.urbe.library.resource;

import edu.urbe.library.entity.Calendar;
import edu.urbe.library.service.CalendarService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * Este recurso REST expone las diferentes operaciones que pueden ser llavadas a cabo con los dias del calendario.
 * @author David Soles
 */
@RestController
public class CalendarResource {

    private CalendarService calendarService;

    public CalendarResource(CalendarService calendarService) {
        this.calendarService = calendarService;
    }

    /**
     * @return Retorna una lista de los dias calendario del mes en curso.
     */
    @RequestMapping(method = RequestMethod.GET, value = "/calendar")
    public List<Calendar> findByCurrentMonth() {
        return calendarService.findByCurrentMonth();
    }

    /**
     * @param month Mes solicitado.
     * @return Retorna una lista de los dias calendario en base al mes solicitado.
     */
    @RequestMapping(method = RequestMethod.GET, value = "/calendar/month/{month}")
    public List<Calendar> findByMonth(@PathVariable Integer month) {
        return calendarService.findByMonth(month);
    }

    /**
     * @param id Identificador del dia calendario.
     * @return Retorna una entidad opcional de tipo calendario.
     */
    @RequestMapping(method = RequestMethod.GET, value = "/calendar/{id}")
    public Optional<Calendar> calendarById(@PathVariable Integer id) {
        return calendarService.calendarById(id);
    }


    /**
     * @param calendar Objeto de tipo calendario se sera utilizado por la capa de servicios para su correcto procesamiento.
     * @return Retorna una entidad de tipo calendario.
     */
    @RequestMapping(method = RequestMethod.POST, value = "/calendar")
    public Calendar addCalendar(@Valid @RequestBody Calendar calendar) {
        return calendarService.addCalendar(calendar);
    }

    /**
     * @param calendar Objeto de tipo calendario con los datos que seran procesados por la capa de servicio.
     * @param id Identificador de la entidad que se desea actualizar.
     * @return Retorna una entidad de tipo calendario con los datos procesados por la capa de servicio.
     */
    @RequestMapping(method = RequestMethod.PUT, value = "/calendar/{id}")
    public Calendar updateCalendar(@RequestBody Calendar calendar, @PathVariable Integer id) {
        return calendarService.updateCalendar(calendar, id);
    }

    /**
     * @param id Identificador del dia calendario que sera utilizado por la capa de servicio para si respectiva eliminacion.
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "/calendar/{id}")
    public void deleteCalendar(@PathVariable Integer id) {
        calendarService.deleteCalendar(id);
    }

}
