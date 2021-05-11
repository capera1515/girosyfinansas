/**
 * 
 */
package com.geomot.co.model.dto;

import java.io.Serializable;

import lombok.Data;

/**
 * @author Andres Capera
 *
 */
@Data
public class PersonaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nombre;
	private Integer edad;
	private String correo;
}
