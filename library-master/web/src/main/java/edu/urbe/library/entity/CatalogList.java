/*
 * Copyright (C) Universidad Privada Dr Rafael Belloso Chacin.
 * Todos los derechos reservados.
 * La divulgación de este material está estrictamente prohibida a menos
 * que cuente con una autorización escrita por parte del propietario o
 * alguna de sus subsidiarias.
 */
package edu.urbe.library.entity;

import java.util.List;

/**
 * Esta clase representa una lista de elementos de tipo {@link Catalog}.
 * @author David Soles
 */
public class CatalogList {

    private List<Catalog> catalogList;

    public CatalogList() {
    }

    public CatalogList(List<Catalog> catalogList) {
        this.catalogList = catalogList;
    }

    /**
     * @return Retorna una lista de elementos de tipo catalogo.
     */
    public List<Catalog> getCatalogList() {
        return catalogList;
    }

    /**
     * @param catalogList Asigna los elementos de la lista de catalogo.
     */
    public void setCatalogList(List<Catalog> catalogList) {
        this.catalogList = catalogList;
    }

    /**
     * @return Imprime el estado de una instancia de lista de Catalogo.
     */
    @Override
    public String toString() {
        return "CatalogList{" +
                "catalogList=" + catalogList +
                '}';
    }

}
