/*
 * Copyright (C) Universidad Privada Dr Rafael Belloso Chacin.
 * Todos los derechos reservados.
 * La divulgación de este material está estrictamente prohibida a menos
 * que cuente con una autorización escrita por parte del propietario o
 * alguna de sus subsidiarias.
 */
package edu.urbe.library.validator;

import edu.urbe.library.entity.BibliographicMaterial;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Esta clase se utiliza para validar las propiedades de la entidad {@link BibliographicMaterial}.
 * @author David Soles
 */
@Component
public class BibliographicMaterialValidator implements Validator {

    /**
     * @param aClass Clase de tipo BibliographicMaterial.class
     * @return Retorna verdadero en caso de que el parametro corresponda a la clase esperada.
     */
    @Override
    public boolean supports(Class<?> aClass) {
        return BibliographicMaterial.class.equals(aClass);
    }

    /**
     * @param object Instancia de un objeto de tipo material bibliografico.
     * @param errors Instancia de un objeto de tipo Errors.
     */
    @Override
    public void validate(Object object, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "abreviatura", "abreviatura.empty");
        ValidationUtils.rejectIfEmpty(errors, "descripcionMtb", "descripcionMtb.empty");
    }

}
