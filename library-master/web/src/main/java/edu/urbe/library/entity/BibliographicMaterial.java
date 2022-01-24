/*
 * Copyright (C) Universidad Privada Dr Rafael Belloso Chacin.
 * Todos los derechos reservados.
 * La divulgación de este material está estrictamente prohibida a menos
 * que cuente con una autorización escrita por parte del propietario o
 * alguna de sus subsidiarias.
 */
package edu.urbe.library.entity;

/**
 * Esta clase representa a la tabla material_bibliografico de la base de datos academica.
 * @author David Soles
 * @version 1.0.0
 */
public class BibliographicMaterial {

    private Integer idMtb;
    private String abreviatura;
    private String descripcionMtb;
    private String internet;
    private String imagenDefecto;
    private String estado;
    private Integer idAcademico;
    private Integer idUsuario;


    /**
     * @return Retorna el identificador primario de un material bibliografico.
     */
    public Integer getIdMtb() {
        return idMtb;
    }

    /**
     * @param idMtb representa el identificador primario de un material bibliografico.
     */
    public void setIdMtb(Integer idMtb) {
        this.idMtb = idMtb;
    }

    /**
     * @return Retorna la abreviatura de un material bibliografico removiendo los espacios en blanco a ambos lados de la cadena de caracteres.
     */
    public String getAbreviatura() {
        return abreviatura.trim();
    }

    /**
     * @param abreviatura Asigna una abreviatura a un material bibliografico. Maximo 8 caracteres.
     */
    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    /**
     * @return Retorna la descripcion de un material bibliografico removiendo los espacios en blanco a ambos lados de la cadena de caracteres.
     */
    public String getDescripcionMtb() {
        return descripcionMtb.trim();
    }

    /**
     * @param descripcionMtb Asigna una descripcion al material bibliografico. Maximo 40 caracteres.
     */
    public void setDescripcionMtb(String descripcionMtb) {
        this.descripcionMtb = descripcionMtb;
    }

    /**
     * @return Retorna un flag que indica si el material bibliografico sera publicado en internet.
     */
    public String getInternet() {
        return internet;
    }

    /**
     * @param internet Asigna un flag que indica si el material bibliografico sera publicado en internet.
     */
    public void setInternet(String internet) {
        this.internet = internet;
    }

    /**
     * @return Retorna la ruta de una imagen por defecto del material bibliografico en formato JPG.
     * Ejemplo: //urbefs/distribucion/...
     */
    public String getImagenDefecto() {
        return imagenDefecto;
    }

    /**
     * @param imagenDefecto Asigna una ruta que apunta a una imagen por defecto que representa al material bibliografico.
     *                      El formato soportado es JPG.
     */
    public void setImagenDefecto(String imagenDefecto) {
        this.imagenDefecto = imagenDefecto;
    }

    /**
     * @return Retorna los diferentes estados de un material bibliografico. Los estados soportados son: <b>A</b> (Activo), <b>I</b> (Inactivo).
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado Asigna un estado al material bibliografico. Los estados soportados son: <b>A</b> (Activo), <b>I</b> (Inactivo).
     */
    public void setEstado(String estado) {
        this.estado = estado;
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
     * @return Retorna el identificador del usuario que creo el material bibliografico.
     */
    public Integer getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario Asigna el identificador del usuario que crea el material bibliografico.
     */
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * @return Imprime el estado de una instancia de material bibliografico.
     */
    @Override
    public String toString() {
        return "BibliographicMaterial{" +
                "idMtb=" + idMtb +
                ", abreviatura='" + abreviatura + '\'' +
                ", descripcionMtb='" + descripcionMtb + '\'' +
                ", internet=" + internet +
                ", imagenDefecto='" + imagenDefecto + '\'' +
                ", estado=" + estado +
                ", idAcademico=" + idAcademico +
                ", idUsuario=" + idUsuario +
                '}';
    }

}
