/**
 * 
 */
package com.geomot.co.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.geomot.co.model.dto.PersonaDTO;
import com.geomot.co.model.dto.StatusResponse;
import com.geomot.co.model.entity.Persona;

/**
 * @author Andres Capera
 *
 */
public interface GeoMotService {
	/**
	 * Metodo de consulta de personas
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Persona> getAllPerson() throws Exception;

	/**
	 * 
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	public ResponseEntity<StatusResponse> insertPerson(PersonaDTO dto) throws Exception;

}
