/**
 * 
 */
package com.geomot.co.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.geomot.co.dao.GeoMotDao;
import com.geomot.co.model.dto.PersonaDTO;
import com.geomot.co.model.dto.StatusResponse;
import com.geomot.co.model.entity.Persona;
import com.geomot.co.service.GeoMotService;
import com.geomot.co.validation.ResponseCodes;
import com.geomot.co.validation.TextoValidation;

/**
 * @author Andres Capera
 *
 */
@Service
@Transactional
public class GeoMotServiceImpl implements GeoMotService {
	@Autowired
	private GeoMotDao service;

	public static final int VL = 0;

	/**
	 * Metodo de consulta de personas
	 * 
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Persona> getAllPerson() throws Exception {
		return service.getAllPerson();
	}

	/**
	 * 
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	@Override
	public ResponseEntity<StatusResponse> insertPerson(PersonaDTO dto) throws Exception {
		StatusResponse statusResponse = null;
		TextoValidation vl = new TextoValidation();
		try {
			if (dto != null && vl.isNullEmpaty(dto.getCorreo()) && vl.isNullEmpaty(String.valueOf(dto.getEdad()))
					&& vl.isNullEmpaty(dto.getNombre())) {
				statusResponse = service.insertPerson(dto);
				return new ResponseEntity<StatusResponse>(statusResponse, HttpStatus.CREATED);
			} else {
				statusResponse = ResponseCodes.UNPROCESSABLE_ENTITY;
				return new ResponseEntity<StatusResponse>(statusResponse, HttpStatus.CREATED);
			}
		} catch (Exception e) {
			statusResponse = ResponseCodes.TECHNICAL_ERROR;
			System.out.println(e.getMessage().toString());
			return new ResponseEntity<StatusResponse>(statusResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
