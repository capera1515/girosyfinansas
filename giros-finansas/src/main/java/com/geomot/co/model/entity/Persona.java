/**
 * 
 */
package com.geomot.co.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

/**
 * @author Andres Capera
 *
 */
@Data
@Entity
@Table(name = "PERSONA")
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	@Column(name = "PER_ID")
	private Integer id;

	@Column(name = "PER_NOMBRE")
	private String nombre;

	@Column(name = "PER_EDAD")
	private Integer edad;

	@Column(name = "PER_CORREO")
	private String correo;

	public Persona() {
	}
}
