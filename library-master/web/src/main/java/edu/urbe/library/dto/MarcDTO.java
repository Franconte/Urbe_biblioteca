/*
 * Copyright (C) Universidad Privada Dr Rafael Belloso Chacin.
 * Todos los derechos reservados.
 * La divulgación de este material está estrictamente prohibida a menos
 * que cuente con una autorización escrita por parte del propietario o
 * alguna de sus subsidiarias.
 */
package edu.urbe.library.dto;

/**
 * Objeto de transferencia de datos que se realiza una proyeccion desde la entidad Marc.
 * @author David Soles
 */
public class MarcDTO {

    private String marctag;
    private String nombre;
    private String subindices;
    private String etiqueta;
    private String uso;
    private String ayudaMarctag;
    private String etiquetaWeb;

    public MarcDTO() {
    }

    public String getMarctag() {
        return marctag;
    }

    public void setMarctag(String marctag) {
        this.marctag = marctag;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSubindices() {
        return subindices;
    }

    public void setSubindices(String subindices) {
        this.subindices = subindices;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public String getUso() {
        return uso;
    }

    public void setUso(String uso) {
        this.uso = uso;
    }

    public String getAyudaMarctag() {
        return ayudaMarctag;
    }

    public void setAyudaMarctag(String ayudaMarctag) {
        this.ayudaMarctag = ayudaMarctag;
    }

    public String getEtiquetaWeb() {
        return etiquetaWeb;
    }

    public void setEtiquetaWeb(String etiquetaWeb) {
        this.etiquetaWeb = etiquetaWeb;
    }

    @Override
    public String toString() {
        return "MarcDto{" +
                "marctag='" + marctag + '\'' +
                ", nombre='" + nombre + '\'' +
                ", subindices='" + subindices + '\'' +
                ", etiqueta='" + etiqueta + '\'' +
                ", uso='" + uso + '\'' +
                ", ayudaMarctag='" + ayudaMarctag + '\'' +
                ", etiquetaWeb='" + etiquetaWeb + '\'' +
                '}';
    }
}
