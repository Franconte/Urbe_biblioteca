/*
 * Copyright (C) Universidad Privada Dr Rafael Belloso Chacin.
 * Todos los derechos reservados.
 * La divulgación de este material está estrictamente prohibida a menos
 * que cuente con una autorización escrita por parte del propietario o
 * alguna de sus subsidiarias.
 */
package edu.urbe.library.resource;

import edu.urbe.library.entity.Catalog;
import edu.urbe.library.service.CatalogService;
import edu.urbe.library.util.Pagination;
import edu.urbe.search.WSLibrarySearch;
import edu.urbe.search.WSLibrarySearchServiceLocator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import javax.xml.rpc.ServiceException;
import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Este recurso REST permite relizar búsquedas sobre los diferentes catálogos de biblioteca.
 * @author David Soles
 */
@RestController
public class SearchResource {

    private CatalogService catalogService;
    private WSLibrarySearchServiceLocator wsLibrarySearchServiceLocator;

    public SearchResource(CatalogService catalogService, WSLibrarySearchServiceLocator wsLibrarySearchServiceLocator) {
        this.catalogService = catalogService;
        this.wsLibrarySearchServiceLocator = wsLibrarySearchServiceLocator;
    }

    /**
     * Este método realiza búsquedas simples a partir de un tipo de material bibliográfico y los parámetros solicitados
     * por el usuario. Se requiere enviar los datos de la paginación. Los resultados obtenidos son solo los títulos y se
     * realiza una limpieza del formato Marc.
     * @param typeMaterial Tipo de Material Bibliografico.
     * @param query Parametros de consulta del usuario.
     * @param page Número de página.
     * @param pageSize Cantidad de registros por página.
     * @return Retorna una lista de entidades de tipo Catálogo.
     */
    @RequestMapping(method = RequestMethod.GET, value = "/singleSearch", params = {"typeMaterial", "query", "page", "pageSize"})
    public List<Catalog> singleSearch(@PathParam("typeMaterial") int typeMaterial, @PathParam("query") String query,
                                      @PathParam("page") int page, @PathParam("pageSize") int pageSize) throws ServiceException, RemoteException {
        WSLibrarySearch service = wsLibrarySearchServiceLocator.getWSLibrarySearchPort();
        List<Integer> searchResults = Arrays.stream(service.singleSearch(typeMaterial, query)).boxed().collect(Collectors.toList());
        List<Integer> pagingResults = Pagination.getPages(searchResults, page, pageSize);
        if (searchResults.isEmpty() || pagingResults.isEmpty())
            return Collections.emptyList();
        List<Catalog> results = catalogService.findByIdCota(pagingResults);
        if (results.isEmpty())
            return Collections.emptyList();
        for (Catalog catalog : results) {
            catalog.setDatos(catalog.getDatos().replaceAll(".*?\\$a|\\$[A-Za-z]", ""));
        }
        return results;
    }

}
