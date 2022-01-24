/*
 * Copyright (C) Universidad Privada Dr Rafael Belloso Chacin.
 * Todos los derechos reservados.
 * La divulgación de este material está estrictamente prohibida a menos
 * que cuente con una autorización escrita por parte del propietario o
 * alguna de sus subsidiarias.
 */
package edu.urbe.library.service;

import edu.urbe.library.repository.CommonRepository;
import org.springframework.stereotype.Service;

/**
 * Este servicio ofrece metodos utilitarios. Por ejemplo: {@code getMaxId} obtiene el siguiente numero disponible de una secuencia especifica.
 * @author David Soles
 */
@Service
public class CommonService {

    private CommonRepository commonRepository;

    public CommonService(CommonRepository commonRepository) {
        this.commonRepository = commonRepository;
    }

    /**
     * @param idName Nombre de una secuencia.
     * @return Siguiente numero disponible de una secuencia.
     */
    public Integer getMaxId(String idName) {
        return commonRepository.getMaxId(idName);
    }

    public Integer getMaxId(String idName, int quantity) {
        return commonRepository.getMaxId(idName, quantity);
    }

}
