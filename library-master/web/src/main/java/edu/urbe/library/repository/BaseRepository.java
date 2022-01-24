/*
 * Copyright (C) Universidad Privada Dr Rafael Belloso Chacin.
 * Todos los derechos reservados.
 * La divulgación de este material está estrictamente prohibida a menos
 * que cuente con una autorización escrita por parte del propietario o
 * alguna de sus subsidiarias.
 */
package edu.urbe.library.repository;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Esta clase declara una instancia JdbcTemplate que es utilizada por los distintos repositorios y
 * que permite seleccionar entre conexiones a distintas bases de datos utilizando la anotacion @Qualifier
 * en el constructor de las sub clases.
 * @author David Soles
 */
public class BaseRepository {

    public final JdbcTemplate jdbcTemplate;

    public BaseRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

}
