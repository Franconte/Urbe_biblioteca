/*
 * Copyright (C) Universidad Privada Dr Rafael Belloso Chacin.
 * Todos los derechos reservados.
 * La divulgación de este material está estrictamente prohibida a menos
 * que cuente con una autorización escrita por parte del propietario o
 * alguna de sus subsidiarias.
 */
package edu.urbe.library.repository;

import edu.urbe.library.entity.BibliographicMaterial;
import edu.urbe.library.util.SQL;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Este repositorio ejecuta las operaciones CRUD de la entidad {@link BibliographicMaterial}
 * @author David Soles
 */
@Repository
public class BibliographicMaterialRepository extends BaseRepository implements CrudRepository<BibliographicMaterial> {

    public BibliographicMaterialRepository(@Qualifier("dburbeJdbcTemplate") JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    /**
     * @return Retorna una lista con el material bibliografico disponible cuyo estado es <u>Activo</u>.
     */
    @Override
    public List<BibliographicMaterial> findAll() {
        return jdbcTemplate.query(SQL.FIND_ALL_BIBLIOGRAPHIC_MATERIAL,
                new Object[]{},
                new BeanPropertyRowMapper<>(BibliographicMaterial.class));
    }

    /**
     * @param id Identificador de un material bibliografico.
     * @return Retorna una entidad opcional con los datos del material bibliografico solicitado.
     */
    @Override
    public Optional<BibliographicMaterial> findById(Integer id) {
        try {
            BibliographicMaterial bibliographicMaterial = jdbcTemplate.queryForObject(SQL.FIND_BIBLIOGRAPHIC_MATERIAL_BY_ID,
                    new Object[]{id},
                    new BeanPropertyRowMapper<>(BibliographicMaterial.class));
            assert bibliographicMaterial != null;
            return Optional.of(bibliographicMaterial);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    /**
     * @param bibliographicMaterial Objeto de tipo material bibliografico con los datos que deben ser almacenados en base de datos.
     * @return Retorna la entidad recien creada con los datos del material bibliografico incluyendo su identificador.
     */
    @Override
    public BibliographicMaterial save(BibliographicMaterial bibliographicMaterial) {
        jdbcTemplate.update(SQL.SAVE_BIBLIOGRAPHIC_MATERIAL, bibliographicMaterial.getIdMtb(),
                bibliographicMaterial.getAbreviatura(), bibliographicMaterial.getDescripcionMtb(),
                bibliographicMaterial.getInternet(), bibliographicMaterial.getImagenDefecto(),
                bibliographicMaterial.getEstado(), bibliographicMaterial.getIdAcademico(),
                bibliographicMaterial.getIdUsuario());
        return bibliographicMaterial;
    }

    /**
     * @param bibliographicMaterial Recibe un objeto de tipo material bibliografico
     *                             con los datos que deben ser actualizados en la base de datos.
     * @return Retorna una entidad con los datos modificados del material bibliografico.
     */
    @Override
    public BibliographicMaterial update(BibliographicMaterial bibliographicMaterial) {
        jdbcTemplate.update(SQL.UPDATE_BIBLIOGRAPHIC_MATERIAL, bibliographicMaterial.getAbreviatura(),
                bibliographicMaterial.getDescripcionMtb(), bibliographicMaterial.getInternet(),
                bibliographicMaterial.getImagenDefecto(), bibliographicMaterial.getEstado(),
                bibliographicMaterial.getIdMtb());
        if (!findById(bibliographicMaterial.getIdMtb()).isPresent())
            return null;
        return findById(bibliographicMaterial.getIdMtb()).get();
    }

    /**
     * @param id Recibe el identificador del material bibliografico que se eliminara de la base de datos.
     */
    @Override
    public void delete(Integer id) {
        jdbcTemplate.update(SQL.DELETE_BIBLIOGRAPHIC_MATERIAL, id);
    }

}
