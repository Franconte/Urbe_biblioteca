/*
 * Copyright (C) Universidad Privada Dr Rafael Belloso Chacin.
 * Todos los derechos reservados.
 * La divulgación de este material está estrictamente prohibida a menos
 * que cuente con una autorización escrita por parte del propietario o
 * alguna de sus subsidiarias.
 */
package edu.urbe.library.entity;

/**
 * Esta clase representa a la tabla plantilla de la base de datos academica.
 * @author David Soles
 */
public class Template {

    private Integer idPlantilla;
    private Integer idMtb;
    private String plantilla;
    private Integer idAcademico;
    private Integer idUsuario;

    /**
     * @return Retorna el identificador de la plantilla.
     */
    public Integer getIdPlantilla() {
        return idPlantilla;
    }

    /**
     * @param idPlantilla Asigna el identificador de la plantilla.
     */
    public void setIdPlantilla(Integer idPlantilla) {
        this.idPlantilla = idPlantilla;
    }

    /**
     * @return Retorna el valor de la llave foranea que vincula la plantilla con el tipo de material bibliografico.
     */
    public Integer getIdMtb() {
        return idMtb;
    }

    /**
     * @param idMtb Asigna una llave foranea para vincular una plantilla con el tipo de material bibliografico.
     */
    public void setIdMtb(Integer idMtb) {
        this.idMtb = idMtb;
    }

    /**
     * @return Obtiene la descripcion de la plantilla.
     */
    public String getPlantilla() {
        return plantilla;
    }

    /**
     * @param plantilla Asigna la descripcion de la plantilla.
     */
    public void setPlantilla(String plantilla) {
        this.plantilla = plantilla;
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
     * @return Retorna el identificador del usuario que crea la Plantilla.
     */
    public Integer getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario Asigna el identificador del usuario que crea la Plantilla.
     */
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * @return Imprime el estado de una instancia de Plantilla.
     */
    @Override
    public String toString() {
        return "Template{" +
                "idPlantilla=" + idPlantilla +
                ", idMtb=" + idMtb +
                ", plantilla='" + plantilla + '\'' +
                ", idAcademico=" + idAcademico +
                ", idUsuario=" + idUsuario +
                '}';
    }

}
