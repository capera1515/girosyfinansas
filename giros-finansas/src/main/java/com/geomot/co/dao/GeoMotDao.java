/**
 * 
 */
package com.geomot.co.dao;

import java.util.List;

import com.geomot.co.model.dto.PersonaDTO;
import com.geomot.co.model.dto.StatusResponse;
import com.geomot.co.model.entity.Persona;

/**
 * @author Andres Capera
 *
 */
public interface GeoMotDao {
	/**
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
	public StatusResponse insertPerson(PersonaDTO dto) throws Exception;

}
