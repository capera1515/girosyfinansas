/**
 * 
 */
package com.geomot.co.model.dto;

import com.geomot.co.model.entity.Persona;

import lombok.Data;

/**
 * @author Andres Capera
 *
 */
@Data
public class MotoResponse {
	private Persona persona;
	private StatusResponse statusResponse;
}
