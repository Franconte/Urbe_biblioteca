/*
 * Copyright (C) Universidad Privada Dr Rafael Belloso Chacin.
 * Todos los derechos reservados.
 * La divulgación de este material está estrictamente prohibida a menos
 * que cuente con una autorización escrita por parte del propietario o
 * alguna de sus subsidiarias.
 */
package edu.urbe.library.entity;

/**
 * Esta clase representa a la tabla campo_control de la base de datos academica.
 * @author David Soles
 */
public class Marc {

    private String nombre;
    private String subindices;
    private String uso;
    private String marctag;
    private String etiqueta;
    private String ayudaMarctag;
    private Integer idAcademico;
    private Integer idUsuario;
    private String etiquetaWeb;

    /**
     * @return Retorna el nombre de la etiqueta Marc.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre Asigna el nombre de la etiqueta Marc.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return Retorna el sub indice de una etiqueta Marc.
     */
    public String getSubindices() {
        return subindices;
    }

    /**
     * @param subindices Asigna sub indices de la etiqueta Marc segun indicaciones de la especificacion.
     */
    public void setSubindices(String subindices) {
        this.subindices = subindices;
    }

    /**
     * @return Retorna el uso de la etiqueta Marc segun la especificacion.
     */
    public String getUso() {
        return uso;
    }

    /**
     * @param uso Describe el uso especifico de la etiqueta Marc segun la especificacion.
     */
    public void setUso(String uso) {
        this.uso = uso;
    }

    /**
     * Este codigo es la llave primaria de la entidad Marc.
     * @return Obtiene el codigo del formato Marc.
     */
    public String getMarctag() {
        return marctag;
    }

    /**
     * Este codigo no puede repetirse debido a que representa la llave primaria de la entidad Marc.
     * @param marctag Asigna el codigo del formato Marc que va desde el 001 hasta el 999 segun la especificacion.
     */
    public void setMarctag(String marctag) {
        this.marctag = marctag;
    }

    /**
     * @return Retorna la etiqueta del formato Marc.
     */
    public String getEtiqueta() {
        return etiqueta;
    }

    /**
     * @param etiqueta Asigna la etiqueta del formato Marc.
     */
    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    /**
     * @return Retorna una micro ayuda sobre la estructura de la etiqueta Marc.
     */
    public String getAyudaMarctag() {
        return ayudaMarctag;
    }

    /**
     * @param ayudaMarctag Asigna una micro ayuda para orientar al usuario final sobre la estructura de la etiqueta Marc.
     */
    public void setAyudaMarctag(String ayudaMarctag) {
        this.ayudaMarctag = ayudaMarctag;
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
     * @return Retorna el identificador del usuario que creo la etiqueta Marc.
     */
    public Integer getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario Asigna el identificador del usuario que crea la etiqueta Marc.
     */
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * @return Retorna la etiqueta personalizada para el portal web.
     */
    public String getEtiquetaWeb() {
        return etiquetaWeb;
    }

    /**
     * @param etiquetaWeb Asigna una etiqueta personalizada para el portal web.
     */
    public void setEtiquetaWeb(String etiquetaWeb) {
        this.etiquetaWeb = etiquetaWeb;
    }

    /**
     * @return Imprime el estado de una instancia de una etiqueta Marc.
     */
    @Override
    public String toString() {
        return "Marc{" +
                "nombre='" + nombre + '\'' +
                ", subindices='" + subindices + '\'' +
                ", uso=" + uso +
                ", marctag='" + marctag + '\'' +
                ", etiqueta='" + etiqueta + '\'' +
                ", ayudaMarctag='" + ayudaMarctag + '\'' +
                ", idAcademico=" + idAcademico +
                ", idUsuario=" + idUsuario +
                ", etiquetaWeb='" + etiquetaWeb + '\'' +
                '}';
    }

}
