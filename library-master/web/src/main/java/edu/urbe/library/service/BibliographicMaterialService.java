/*
 * Copyright (C) Universidad Privada Dr Rafael Belloso Chacin.
 * Todos los derechos reservados.
 * La divulgación de este material está estrictamente prohibida a menos
 * que cuente con una autorización escrita por parte del propietario o
 * alguna de sus subsidiarias.
 */
package edu.urbe.library.service;

import edu.urbe.library.dto.BibliographicMaterialDTO;
import edu.urbe.library.entity.BibliographicMaterial;
import edu.urbe.library.exception.EntityNotFound;
import edu.urbe.library.repository.BibliographicMaterialRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Este servicio contiene toda la logica relacionada con el material bibliografico.
 * @author David Soles
 */
@Service
public class BibliographicMaterialService {

    private static final Logger logger = LoggerFactory.getLogger(BibliographicMaterialService.class);

    private CommonService commonService;
    private BibliographicMaterialRepository bibliographicMaterialRepository;

    public BibliographicMaterialService(CommonService commonService, BibliographicMaterialRepository bibliographicMaterialRepository) {
        this.commonService = commonService;
        this.bibliographicMaterialRepository = bibliographicMaterialRepository;
    }

    /**
     * @return Lista del material bibliografico.
     */
    public List<BibliographicMaterialDTO> findAll() {
        List<BibliographicMaterial> param = (List<BibliographicMaterial>) bibliographicMaterialRepository.findAll();
        return param.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    /**
     * @param id Identificador de un material bibliografico.
     * @return Retorna un objeto opcional de tipo material bibliografico. Si la entidad buscada no existe devuelve una excepcion de tipo {@link EntityNotFound}.
     */
    public Optional<BibliographicMaterial> bibliographicMaterialById(Integer id) {
        Optional<BibliographicMaterial> bibliographicMaterial = bibliographicMaterialRepository.findById(id);
        if (!bibliographicMaterial.isPresent())
            throw new EntityNotFound("No se encontro un resultado con el valor: " + id);
        return bibliographicMaterial;
    }

    /**
     * Este metodo hace uso del servicio {@link CommonService} el cual permite generar el siguiente identificador disponible para una llave primaria especifica.
     * @param bibliographicMaterial Objeto de tipo material bibliografico que contiene los datos necesarios para un nuevo registro.
     * @return Retorna un objecto de tipo material bibliografico con los datos del registro recien creado incluyendo el identificador.
     */
    public BibliographicMaterial addBibliographicMaterial(BibliographicMaterial bibliographicMaterial) {
        logger.info("POST -> /bibliographicMaterial -> " + bibliographicMaterial);
        bibliographicMaterial.setIdMtb(commonService.getMaxId("id_mtb"));
        return bibliographicMaterialRepository.save(bibliographicMaterial);
    }

    /**
     * @param bibliographicMaterial Objeto de tipo material bibliografico que contiene los datos que van a ser actualizados.
     * @param id Llave primaria de la entidad material bibliografico que sera actualizado.
     * @return Retorna un objeto de tipo material bibliografico con los datos actualizados.
     */
    public BibliographicMaterial updateBibliographicMaterial(BibliographicMaterial bibliographicMaterial, Integer id) {
        Optional<BibliographicMaterial> bibliographyOptional = bibliographicMaterialRepository.findById(id);
        if (!bibliographyOptional.isPresent())
            throw new EntityNotFound("No hay resultado por el valor: " + id);
        return bibliographicMaterialRepository.update(bibliographicMaterial);
    }

    /**
     * @param id Llave primaria de la entidad material bibliografico que sera eliminada.
     */
    public void deleteBibliographicMaterial(Integer id) {
        Optional<BibliographicMaterial> bibliographicMaterial = bibliographicMaterialRepository.findById(id);
        if (!bibliographicMaterial.isPresent())
            throw new EntityNotFound("El material bibliográfico que desea eliminar no existe");
        bibliographicMaterialRepository.delete(id);
    }

    private BibliographicMaterialDTO convertToDto(BibliographicMaterial bibliographicMaterial) {
        return new ModelMapper().map(bibliographicMaterial, BibliographicMaterialDTO.class);
    }

}
