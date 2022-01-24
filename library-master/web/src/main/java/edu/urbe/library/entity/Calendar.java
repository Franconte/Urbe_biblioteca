/*
 * Copyright (C) Universidad Privada Dr Rafael Belloso Chacin.
 * Todos los derechos reservados.
 * La divulgación de este material está estrictamente prohibida a menos
 * que cuente con una autorización escrita por parte del propietario o
 * alguna de sus subsidiarias.
 */
package edu.urbe.library.entity;

import java.util.Date;

/**
 * Esta clase representa a la tabla calendario de la base de datos academica.
 * @author David Soles
 */
public class Calendar {

    private Integer idCalendario;
    private Date fechaGracia;
    private String descFecha;
    private String fijoFestivo;
    private Integer idAcademico;
    private Integer idUsuario;

    /**
     * @return Retorna el identificador primario de un dia calendario.
     */
    public Integer getIdCalendario() {
        return idCalendario;
    }

    /**
     * @param idCalendario Asigna el identificador primario de un dia calendario.
     */
    public void setIdCalendario(Integer idCalendario) {
        this.idCalendario = idCalendario;
    }

    /**
     * @return Retorna la fecha de gracia de un dia calendario.
     */
    public Date getFechaGracia() {
        return fechaGracia;
    }

    /**
     * @param fechaGracia Asigna la fecha de gracia de un dia calendario.
     */
    public void setFechaGracia(Date fechaGracia) {
        this.fechaGracia = fechaGracia;
    }

    /**
     * @return Retorna la descripcion de la fecha de gracia. Ejemplo: Navidad.
     */
    public String getDescFecha() {
        return descFecha.trim();
    }

    /**
     * @param descFecha Asigna la descripcion de la fecha de gracia. Ejemplo: Feria de la Chinita.
     */
    public void setDescFecha(String descFecha) {
        this.descFecha = descFecha;
    }

    /**
     * @return Retorna un caracter que indica si la fecha es fija o variable. Un ejemplo de fecha fija
     * es Navidad pues siempre se realiza los 24 de diciembre de cada ano. Un ejemplo de fecha variable
     * es el jueves y viernes santo debido a que se realizan es distintas fechas cada ano.
     * <b>1</b> (Fija) <b>0</b> (Variable).
     */
    public String getFijoFestivo() {
        return fijoFestivo;
    }

    /**
     * @param fijoFestivo Asigna un caracter que indica si la fecha es fija o variable. <b>1</b> (Fija) <b>0</b> (Variable).
     */
    public void setFijoFestivo(String fijoFestivo) {
        this.fijoFestivo = fijoFestivo;
    }

    /**
     * @return Obtiene el identificador de la academia.
     */
    public Integer getIdAcademico() {
        return idAcademico;
    }

    /**
     * @param idAcademico Asigna el identificador de la academia.
     */
    public void setIdAcademico(Integer idAcademico) {
        this.idAcademico = idAcademico;
    }

    /**
     * @return Retorna el identificador del usuario que creo el dia calendario.
     */
    public Integer getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario Asigna el identificador del usuario que crea el dia calendario.
     */
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * @return Imprime el estado de una instancia de calendario.
     */
    @Override
    public String toString() {
        return "Calendar{" +
                "idCalendario=" + idCalendario +
                ", fechaGracia=" + fechaGracia +
                ", descFecha='" + descFecha + '\'' +
                ", fijoFestivo=" + fijoFestivo +
                ", idAcademico=" + idAcademico +
                ", idUsuario=" + idUsuario +
                '}';
    }

}
