/*
 * Copyright (C) Universidad Privada Dr Rafael Belloso Chacin.
 * Todos los derechos reservados.
 * La divulgación de este material está estrictamente prohibida a menos
 * que cuente con una autorización escrita por parte del propietario o
 * alguna de sus subsidiarias.
 */
package edu.urbe.library.repository;

import edu.urbe.library.util.SQL;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * Repositorio comun que contiene metodos utilizados a lo largo de toda la aplicacion.
 * @author David Soles
 */
@Repository
public class CommonRepository extends BaseRepository {

    public CommonRepository(@Qualifier("dburbeJdbcTemplate") JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    /**
     * @param idName Nombre de una secuencia.
     * @return Retorna el siguiente número disponible en la secuencia especificada.
     */
    public Integer getMaxId(String idName) {
        Map<String, Object> map = jdbcTemplate.queryForMap(SQL.SP_MAX_ID, idName);
        Integer maxId = (Integer) map.get("retorno");
        return maxId;
    }

    /**
     * @param idName Nombre de la secuencia.
     * @param quantity Cantidad de números a reservar.
     * @return Retorna el siguiente número disponible en la secuencia especificada no pudiendo ser mayor a dicho valor mas
     * la cantidad indicada. Ejemplo: si la cantidad reservada es de 5 y el número retornado es 705 los números válidos a ingresar
     * son: 706, 707, 708, 709 y 710.
     */
    public Integer getMaxId(String idName, int quantity) {
        Map<String, Object> map = jdbcTemplate.queryForMap(SQL.SP_RESERVE_MAX_ID, idName, quantity);
        Integer maxId = (Integer) map.get("retorno");
        return maxId;
    }

}
