package edu.urbe.library.repository;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz que define la funcionalidad basica de un repositorio.
 * @author David Soles
 */
public interface CrudRepository<T> {

    List<T> findAll();

    Optional<T> findById(Integer id);

    T save(T t);

    T update(T t);

    void delete(Integer t);

}
