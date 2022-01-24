/*
 * Copyright (C) Universidad Privada Dr Rafael Belloso Chacin.
 * Todos los derechos reservados.
 * La divulgación de este material está estrictamente prohibida a menos
 * que cuente con una autorización escrita por parte del propietario o
 * alguna de sus subsidiarias.
 */
package edu.urbe.library.resource;

import edu.urbe.library.entity.Catalog;
import edu.urbe.library.entity.CatalogList;
import edu.urbe.library.service.CatalogService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * @author David Soles
 */
@RestController
public class CatalogResource {

    private CatalogService catalogService;

    public CatalogResource(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/catalog", params = {"idCota"})
    public List<Catalog> findAllByIdCota(@PathParam("idCota") Integer idCota) {
        return catalogService.findByIdCota(idCota);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/catalog")
    public CatalogList addCatalog(@RequestBody CatalogList catalogs) {
        return catalogService.save(catalogs);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/catalog", params = {"idCota"})
    public CatalogList updateCatalog(@RequestBody CatalogList catalogs, @PathParam("idCota") Integer idCota) {
        return catalogService.edit(catalogs);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/catalog", params = {"idCota"})
    public void deleteCatalog(@PathParam("idCota") Integer idCota) {
        catalogService.deleteByIdCota(idCota);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/catalog", params = {"idCota", "idCatalogo"})
    public void deleteCatalogItem(@PathParam("idCota") Integer idCota, @PathParam("idCatalogo") Integer idCatalogo) {
        catalogService.deleteById(idCota, idCatalogo);
    }

}
