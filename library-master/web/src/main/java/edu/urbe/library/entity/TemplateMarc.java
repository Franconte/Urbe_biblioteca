/*
 * Copyright (C) Universidad Privada Dr Rafael Belloso Chacin.
 * Todos los derechos reservados.
 * La divulgación de este material está estrictamente prohibida a menos
 * que cuente con una autorización escrita por parte del propietario o
 * alguna de sus subsidiarias.
 */
package edu.urbe.library.entity;

/**
 * @author David Soles
 */
public class TemplateMarc {

    private Integer idPlantilla;
    private String marctag;

    public Integer getIdPlantilla() {
        return idPlantilla;
    }

    public void setIdPlantilla(Integer idPlantilla) {
        this.idPlantilla = idPlantilla;
    }

    public String getMarctag() {
        return marctag;
    }

    public void setMarctag(String marctag) {
        this.marctag = marctag;
    }

    @Override
    public String toString() {
        return "TemplateMarc{" +
                "idPlantilla=" + idPlantilla +
                ", marctag='" + marctag + '\'' +
                '}';
    }

}
