/*
 * Copyright (C) Universidad Privada Dr Rafael Belloso Chacin.
 * Todos los derechos reservados.
 * La divulgación de este material está estrictamente prohibida a menos
 * que cuente con una autorización escrita por parte del propietario o
 * alguna de sus subsidiarias.
 */
package edu.urbe.library.dto;

/**
 * Objeto de transferencia de datos que se realiza una proyeccion desde la entidad BibliographicMaterial.
 * @author David Soles
 */
public class BibliographicMaterialDTO {

    private Integer IdMtb;
    private String Abreviatura;
    private String DescripcionMtb;
    private String Internet;
    private String ImagenDefecto;
    private String Estado;

    public BibliographicMaterialDTO() {}

    public Integer getIdMtb() {
        return IdMtb;
    }

    public void setIdMtb(Integer idMtb) {
        IdMtb = idMtb;
    }

    public String getAbreviatura() {
        return Abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        Abreviatura = abreviatura;
    }

    public String getDescripcionMtb() {
        return DescripcionMtb;
    }

    public void setDescripcionMtb(String descripcionMtb) {
        DescripcionMtb = descripcionMtb;
    }

    public String getInternet() {
        return Internet;
    }

    public void setInternet(String internet) {
        Internet = internet;
    }

    public String getImagenDefecto() {
        return ImagenDefecto;
    }

    public void setImagenDefecto(String imagenDefecto) {
        ImagenDefecto = imagenDefecto;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    @Override
    public String toString() {
        return "BibliographyDto{" +
                "IdMtb=" + IdMtb +
                ", Abreviatura='" + Abreviatura + '\'' +
                ", DescripcionMtb='" + DescripcionMtb + '\'' +
                ", Internet='" + Internet + '\'' +
                ", ImagenDefecto='" + ImagenDefecto + '\'' +
                ", Estado='" + Estado + '\'' +
                '}';
    }
}
