package com.geomot.co.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.geomot.co.model.dto.PersonaDTO;
import com.geomot.co.model.dto.StatusResponse;
import com.geomot.co.model.entity.Persona;
import com.geomot.co.service.GeoMotService;

@CrossOrigin
@RestController
@RequestMapping(value = "v1/")
public class GeoMotController {

	@Autowired
	GeoMotService service;

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "persona", method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	public List<Persona> getAllPerson() throws Exception {
		return service.getAllPerson();
	}

	/**
	 * 
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "persona", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public ResponseEntity<StatusResponse> insertPerson(@RequestBody PersonaDTO dto) throws Exception {
		ResponseEntity<StatusResponse> response;
		try {
			response = service.insertPerson(dto);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return response;
	}

}
