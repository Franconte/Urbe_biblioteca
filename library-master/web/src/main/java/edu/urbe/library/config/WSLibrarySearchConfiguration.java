/*
 * Copyright (C) Universidad Privada Dr Rafael Belloso Chacin.
 * Todos los derechos reservados.
 * La divulgación de este material está estrictamente prohibida a menos
 * que cuente con una autorización escrita por parte del propietario o
 * alguna de sus subsidiarias.
 */
package edu.urbe.library.config;

import edu.urbe.search.WSLibrarySearchServiceLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configura la conexión con el servicio SOAP para búsquedas de biblioteca.
 * @author David Soles
 */
@Configuration
public class WSLibrarySearchConfiguration {

    @Bean
    public WSLibrarySearchServiceLocator wsLibrarySearchServiceLocator() {
        return new WSLibrarySearchServiceLocator();
    }

}
