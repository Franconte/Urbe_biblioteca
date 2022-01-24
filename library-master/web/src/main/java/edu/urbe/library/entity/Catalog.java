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
 * Esta clase representa a la tabla catalogo de la base de datos academica.
 * @author David Soles
 */
public class Catalog {

    private Integer id;
    private Integer idMtb;
    private String marctag;
    private Integer idCota;
    private String datos;
    private Date fechaCrea;
    private Date fechaUltmod;
    private int idAcademico;
    private int idUsuario;

    public Catalog() {
    }

    /**
     * @return Retorna el identificador de la entidad catalogo.
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id Asigna el identificador de la entidad catalogo.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return Retorna una entidad de tipo {@link BibliographicMaterial}.
     */
    public Integer getIdMtb() {
        return idMtb;
    }

    /**
     * @param idMtb Asigna el identificador de una entidad de tipo {@link BibliographicMaterial}.
     */
    public void setIdMtb(Integer idMtb) {
        this.idMtb = idMtb;
    }

    /**
     * @return Retorna la etiqueta Marc del registro catalogado.
     */
    public String getMarctag() {
        return marctag;
    }

    /**
     * @param marctag Asigna la etiqueta Marc del registro que esta siendo catalogado.
     */
    public void setMarctag(String marctag) {
        this.marctag = marctag;
    }

    /**
     * @return Retorna la cota de un registro catalogado.
     */
    public Integer getIdCota() {
        return idCota;
    }

    /**
     * @param idCota Asigna la cota del catalogo. Este dato agrupa un conjunto de registros que corresponden a un material bibliográfico.
     */
    public void setIdCota(Integer idCota) {
        this.idCota = idCota;
    }

    /**
     * @return Retorna los datos del catalogo.
     */
    public String getDatos() {
        return datos;
    }

    /**
     * @param datos Asigna los datos del catalogo. Por ejemplo: datos del libro, autor, isbn, entre otros.
     */
    public void setDatos(String datos) {
        this.datos = datos;
    }

    /**
     * @return Obtiene la fecha en que fue creado el registro de catalogo.
     */
    public Date getFechaCrea() {
        return fechaCrea;
    }

    /**
     * @param fechaCrea Asigna la fecha en que se crea el registro. Fecha de la base de datos.
     */
    public void setFechaCrea(Date fechaCrea) {
        this.fechaCrea = fechaCrea;
    }

    /**
     * @return Retorna la fecha en que se realizó la última modificación del registro de catalogo.
     */
    public Date getFechaUltmod() {
        return fechaUltmod;
    }

    /**
     * @param fechaUltmod Asigna la fecha de la ultima modificación realizada sobre el registro de catalogo.
     */
    public void setFechaUltmod(Date fechaUltmod) {
        this.fechaUltmod = fechaUltmod;
    }

    /**
     * @return Retorna el identificador de la academia.
     */
    public int getIdAcademico() {
        return idAcademico;
    }

    /**
     * @param idAcademico Asigna el identificador de la academia.
     */
    public void setIdAcademico(int idAcademico) {
        this.idAcademico = idAcademico;
    }

    /**
     * @return Retorna el identificador del usuario que creo el registro de catalogo.
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario Asigna el identificador del usuario que crea el registro de catalogo.
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * @return Imprime el estado de una instancia de Catalogo.
     */
    @Override
    public String toString() {
        return "Catalog{" +
                "id=" + id +
                ", idMtb=" + idMtb +
                ", marc='" + marctag + '\'' +
                ", idCota=" + idCota +
                ", datos='" + datos + '\'' +
                ", fechaCrea=" + fechaCrea +
                ", fechaUltmod=" + fechaUltmod +
                ", idAcademico=" + idAcademico +
                ", idUsuario=" + idUsuario +
                '}';
    }

}
