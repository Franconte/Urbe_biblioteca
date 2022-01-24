/*
 * Copyright (C) Universidad Privada Dr Rafael Belloso Chacin.
 * Todos los derechos reservados.
 * La divulgación de este material está estrictamente prohibida a menos
 * que cuente con una autorización escrita por parte del propietario o
 * alguna de sus subsidiarias.
 */
package edu.urbe.library.dto;

/**
 * Objeto de transferencia de datos que se realiza una proyeccion desde la entidad Parameter.
 * @author David Soles
 */
public class ParameterDTO {

    private int idParametro;
    private int idAplicacion;
    private String DescripcionPar;
    private Integer Valor;
    private String EstadoParametro;

    public int getIdParametro() {
        return idParametro;
    }

    public void setIdParametro(int idParametro) {
        this.idParametro = idParametro;
    }

    public int getIdAplicacion() {
        return idAplicacion;
    }

    public void setIdAplicacion(int idAplicacion) {
        this.idAplicacion = idAplicacion;
    }

    public String getDescripcionPar() {
        return DescripcionPar;
    }

    public void setDescripcionPar(String descripcionPar) {
        DescripcionPar = descripcionPar;
    }

    public Integer getValor() {
        return Valor;
    }

    public void setValor(Integer valor) {
        Valor = valor;
    }

    public String getEstadoParametro() {
        return EstadoParametro;
    }

    public void setEstadoParametro(String estadoParametro) {
        EstadoParametro = estadoParametro;
    }

    @Override
    public String toString() {
        return "ParameterDto{" +
                "idParametro=" + idParametro +
                ", idAplicacion=" + idAplicacion +
                ", DescripcionPar='" + DescripcionPar + '\'' +
                ", Valor=" + Valor +
                ", EstadoParametro='" + EstadoParametro + '\'' +
                '}';
    }

}


