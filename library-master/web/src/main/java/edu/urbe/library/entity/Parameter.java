/*
 * Copyright (C) Universidad Privada Dr Rafael Belloso Chacin.
 * Todos los derechos reservados.
 * La divulgación de este material está estrictamente prohibida a menos
 * que cuente con una autorización escrita por parte del propietario o
 * alguna de sus subsidiarias.
 */
package edu.urbe.library.entity;

/**
 * Esta clase representa a la tabla parametro de la base de datos academica.
 * @author David Soles
 */
public class Parameter {

    private int idParametro;
    private String descripcionPar;
    private Integer valor;
    private Integer idAcademico;
    private Integer idUsuario;
    private int idAplicacion;
    private String estadoParametro;

    /**
     * @return Obtiene el valor del parametro.
     */
    public int getIdParametro() {
        return idParametro;
    }

    /**
     * @param idParametro Asigna el identificador del parametro. Posteriormente, este numero se utiliza para recuperar su valor
     *                    y realizar diversos calculos durante la operatividad de la aplicacion. Ejemplo: dias de retraso, valor de la multa.
     */
    public void setIdParametro(int idParametro) {
        this.idParametro = idParametro;
    }

    /**
     * @return Obtiene la descripcion del parametro.
     */
    public String getDescripcionPar() {
        return descripcionPar;
    }

    /**
     * @param descripcionPar Asigna la descripcion del parametro.
     */
    public void setDescripcionPar(String descripcionPar) {
        this.descripcionPar = descripcionPar;
    }

    /**
     * @return Obtiene el valor entero del parametro.
     */
    public Integer getValor() {
        return valor;
    }

    /**
     * @param valor Asigna el valor entero del parametro.
     */
    public void setValor(Integer valor) {
        this.valor = valor;
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
     * @return Retorna el identificador del usuario que crea el parametro.
     */
    public Integer getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario Asigna el identificador del usuario que crea el Parametro.
     */
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * @return Obtiene el identificador de la aplicacion.
     */
    public int getIdAplicacion() {
        return idAplicacion;
    }

    /**
     * @param idAplicacion Especifica el identificador de la aplicacion. La tabla parametro es utilizada por multiples aplicaciones.
     *                     En el caso especifico de biblioteca el identificador es 2 y se asigna en el archivo de propiedades.
     */
    public void setIdAplicacion(int idAplicacion) {
        this.idAplicacion = idAplicacion;
    }

    /**
     * @return Obtiene el estado del parametro.
     */
    public String getEstadoParametro() {
        return estadoParametro;
    }

    /**
     * @param estadoParametro Asigna el estado del parametro. <b>A</b> (Activo) <b>I</b> (Inactivo)
     */
    public void setEstadoParametro(String estadoParametro) {
        this.estadoParametro = estadoParametro;
    }

    /**
     * @return Imprime el estado de una instancia de Parametro.
     */
    @Override
    public String toString() {
        return "Parameter{" +
                "idParametro=" + idParametro +
                ", descripcionPar='" + descripcionPar + '\'' +
                ", valor=" + valor +
                ", idAcademico=" + idAcademico +
                ", idUsuario=" + idUsuario +
                ", idAplicacion=" + idAplicacion +
                ", estadoParametro=" + estadoParametro +
                '}';
    }

}
