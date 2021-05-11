/**
 * 
 */
package com.geomot.co.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.geomot.co.dao.GeoMotDao;
import com.geomot.co.model.dto.PersonaDTO;
import com.geomot.co.model.dto.StatusResponse;
import com.geomot.co.model.entity.Persona;
import com.geomot.co.validation.ResponseCodes;

/**
 * @author Andres Capera
 *
 */
@Repository
public class GeoMotDaoImpl implements GeoMotDao {
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	protected Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	/**
	 * Metodo de consulta de personas
	 * 
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<Persona> getAllPerson() throws Exception {
		List<Persona> personas = new ArrayList<>();
		try {
			personas = getSession().createQuery("from Persona").list();
		} catch (Exception e) {
			throw new Exception();
		}
		return personas;
	}

	/**
	 * 
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	public StatusResponse insertPerson(PersonaDTO dto) throws Exception {
		StatusResponse statusResponse = null;
		Persona moto = new Persona();
		try {
			moto.setNombre(dto.getNombre());
			moto.setEdad(dto.getEdad());
			moto.setCorreo(dto.getCorreo());
			getSession().save(moto);
			statusResponse = ResponseCodes.SUCCESS;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return statusResponse;
	}

}
