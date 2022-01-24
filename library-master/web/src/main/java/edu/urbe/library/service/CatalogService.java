/*
 * Copyright (C) Universidad Privada Dr Rafael Belloso Chacin.
 * Todos los derechos reservados.
 * La divulgación de este material está estrictamente prohibida a menos
 * que cuente con una autorización escrita por parte del propietario o
 * alguna de sus subsidiarias.
 */
package edu.urbe.library.service;

import edu.urbe.library.entity.Catalog;
import edu.urbe.library.entity.CatalogList;
import edu.urbe.library.repository.CatalogRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author David Soles
 */
@Service
public class CatalogService {

    @Value("${edu.urbe.academy}")
    private int academy;

    private CommonService commonService;
    private CatalogRepository catalogRepository;

    public CatalogService(CommonService commonService, CatalogRepository catalogRepository) {
        this.commonService = commonService;
        this.catalogRepository = catalogRepository;
    }

    public List<Catalog> findByIdCota(Integer idCota) {
        return catalogRepository.findByIdCota(idCota);
    }

    public List<Catalog> findByIdCota(List<Integer> idCotas) {
        return catalogRepository.findByIdCota(idCotas);
    }

    public CatalogList save(CatalogList catalogs) {
        Integer maxId = commonService.getMaxId("id_cota");
        for (Catalog catalog : catalogs.getCatalogList()) {
            catalog.setIdCota(maxId);
            catalog.setIdAcademico(academy);
        }
        return new CatalogList(catalogRepository.save(catalogs.getCatalogList()));
    }

    public CatalogList edit(CatalogList catalogs) {
        Integer maxId = catalogs.getCatalogList().get(0).getIdCota();
        List<Catalog> catalogAdditions = catalogs.getCatalogList().stream().filter(c -> c.getId() == null).collect(Collectors.toList());
        for (Catalog catalog : catalogAdditions) {
            catalog.setIdCota(maxId);
            catalog.setIdAcademico(academy);
            catalog.setIdUsuario(0);
            catalogRepository.save(catalog);
        }
        List<Catalog> catalogsToEdit = catalogs.getCatalogList().stream().filter(c -> c.getId() != null).collect(Collectors.toList());
        return new CatalogList(catalogRepository.update(catalogsToEdit));
    }

    public void deleteById(Integer idCota, Integer idCatalogo) {
        catalogRepository.delete(idCota, idCatalogo);
    }

    public void deleteByIdCota(Integer idCota) {
        catalogRepository.delete(idCota);
    }

}
