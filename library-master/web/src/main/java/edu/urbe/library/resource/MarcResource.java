/*
 * Copyright (C) Universidad Privada Dr Rafael Belloso Chacin.
 * Todos los derechos reservados.
 * La divulgación de este material está estrictamente prohibida a menos
 * que cuente con una autorización escrita por parte del propietario o
 * alguna de sus subsidiarias.
 */
package edu.urbe.library.resource;

import edu.urbe.library.dto.MarcDTO;
import edu.urbe.library.entity.Marc;
import edu.urbe.library.service.MarcService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Este recurso REST expone las diferentes operaciones que pueden ser llavadas a cabo con las etiquetas del formato Marc.
 * @author David Soles
 */
@RestController
public class MarcResource {

	private MarcService marcService;

	public MarcResource(MarcService marcService) {
		this.marcService = marcService;
	}

    /**
     * @return Retorna una lista de etiquetas Marc.
     */
	@RequestMapping(method = RequestMethod.GET, value = "/marc")
	public List<MarcDTO> findAll() {
		return marcService.findAll();
	}

    /**
     * @param tag Etiqueta Marctag que desea obtener.
     * @return Retorna una entidad opcional de etiqueta Marc.
     */
	@RequestMapping(method = RequestMethod.GET, value = "/marc/{tag}")
	public Optional<Marc> marcById(@PathVariable String tag) {
		return marcService.marcById(tag);
	}

    /**
     * @param marc Objeto de tipo Marc que contiene los datos que seran ingresados a la base de datos.
     * @return Retorna una entidad de tipo Marc con los datos almacenados en la base de datos.
     */
	@RequestMapping(method = RequestMethod.POST, value = "/marc")
	public Marc addMarc(@Validated @RequestBody Marc marc) {
		return marcService.addMarc(marc);
	}

    /**
     * @param marc Objeto de tipo Marc con los datos que seran actualizados en la base de datos.
     * @param tag Etiqueta Marc de la entidad que se actualizara.
     * @return Retorna una entidad de tipo Marc con los datos actualizados.
     */
	@RequestMapping(method = RequestMethod.PUT, value = "/marc/{tag}")
	public Marc updateMarc(@RequestBody Marc marc, @PathVariable String tag) {
		return marcService.updateMarc(marc, tag);
	}

    /**
     * @param tag Etiqueta Marc que se eliminara de la base de datos.
     */
	@RequestMapping(method = RequestMethod.DELETE, value = "/marc/{tag}")
	public void deleteMarc(@PathVariable String tag) {
		marcService.deleteMarc(tag);
	}

}
