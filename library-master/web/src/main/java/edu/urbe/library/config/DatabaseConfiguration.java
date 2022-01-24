/*
 * Copyright (C) Universidad Privada Dr Rafael Belloso Chacin.
 * Todos los derechos reservados.
 * La divulgación de este material está estrictamente prohibida a menos
 * que cuente con una autorización escrita por parte del propietario o
 * alguna de sus subsidiarias.
 */
package edu.urbe.library.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Clase que realiza la configuracion de la base de datos segun especificaciones de conexion del archivo {@code properties}
 * y en sus diferentes perfiles: dev, prod, test.
 * @author David Soles
 */
@Configuration
public class DatabaseConfiguration {

	/**
	 * @return Retorna un objeto con las propiedades de conexion a la base de datos.
	 */
	@Bean
	@Primary
	@ConfigurationProperties(prefix = "dburbe")
	public DataSourceProperties dbProperties() {
		return new DataSourceProperties();
	}

	/**
	 * @return Retorna un objeto de conexion a la base de datos.
	 */
	@Bean(name = "dburbeHikariDataSource")
	@Primary
	@ConfigurationProperties(prefix = "dburbe.hikari")
	public HikariDataSource dbDataSource() {
		return dbProperties().initializeDataSourceBuilder().type(HikariDataSource.class).build();
	}

	/**
	 * @param dbDataSource Crea un objeto de tipo JdbcTemplate, utilizando una instancia de conexion a la base de datos.
	 * @return Retorna un objeto de tipo JdbcTemplate.
	 */
	@Bean(name = "dburbeJdbcTemplate")
	public JdbcTemplate jdbcTemplate(@Qualifier("dburbeHikariDataSource") HikariDataSource dbDataSource) {
		return new JdbcTemplate(dbDataSource, false);
	}

}
