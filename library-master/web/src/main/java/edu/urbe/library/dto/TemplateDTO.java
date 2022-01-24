/*
 * Copyright (C) Universidad Privada Dr Rafael Belloso Chacin.
 * Todos los derechos reservados.
 * La divulgación de este material está estrictamente prohibida a menos
 * que cuente con una autorización escrita por parte del propietario o
 * alguna de sus subsidiarias.
 */
package edu.urbe.library.dto;

/**
 * Objeto de transferencia de datos que se realiza una proyeccion desde la entidad Template.
 * @author David Soles
 */
public class TemplateDTO {

    private Integer idPlantilla;
    private String plantilla;

    public TemplateDTO() {}

    public Integer getIdPlantilla() {
        return idPlantilla;
    }

    public void setIdPlantilla(Integer idPlantilla) {
        this.idPlantilla = idPlantilla;
    }

    public String getPlantilla() {
        return plantilla;
    }

    public void setPlantilla(String plantilla) {
        this.plantilla = plantilla;
    }

    @Override
    public String toString() {
        return "TemplateDto{" +
                "idPlantilla=" + idPlantilla +
                ", plantilla='" + plantilla + '\'' +
                '}';
    }
}

