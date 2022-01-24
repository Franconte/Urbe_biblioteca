package edu.urbe.library.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Esta clase es utilizada para retornar una excepcion personalizada en caso de que una entidad
 * no exista en la base de datos.
 * @author David Soles
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EntityNotFound extends RuntimeException {

    public EntityNotFound(String exception) {
        super(exception);
    }

}
