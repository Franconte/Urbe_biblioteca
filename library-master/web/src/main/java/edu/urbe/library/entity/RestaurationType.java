package edu.urbe.library.entity;

/**
 * Esta clase representa a la tabla tipo_restauracion de la base de datos academica.
 * @author David Soles
 */
public class RestaurationType {

    private Integer idTipoRestauracion;
    private String tipoRestauracion;
    private Integer idAcademico;
    private Integer idUsuario;

    /**
     * @return Obtiene el identificador del tipo de restauracion.
     */
    public Integer getIdTipoRestauracion() {
        return idTipoRestauracion;
    }

    /**
     * @param idTipoRestauracion Asigna el identificador del tipo de restauracion.
     */
    public void setIdTipoRestauracion(Integer idTipoRestauracion) {
        this.idTipoRestauracion = idTipoRestauracion;
    }

    /**
     * @return Retorna la descripcion del tipo de restauracion.
     */
    public String getTipoRestauracion() {
        return tipoRestauracion;
    }

    /**
     * @param tipoRestauracion Asigna una descripcion al tipo de restauracion.
     */
    public void setTipoRestauracion(String tipoRestauracion) {
        this.tipoRestauracion = tipoRestauracion;
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
     * @return Retorna el identificador del usuario que crea el Tipo de Restauracion.
     */
    public Integer getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario Asigna el identificador del usuario que crea el Tipo de Restauracion.
     */
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * @return Imprime el estado de una instancia de Tipo de Restauracion.
     */
    @Override
    public String toString() {
        return "RestaurationType{" +
                "idTipoRestauracion=" + idTipoRestauracion +
                ", tipoRestauracion='" + tipoRestauracion + '\'' +
                ", idAcademico=" + idAcademico +
                ", idUsuario=" + idUsuario +
                '}';
    }

}
