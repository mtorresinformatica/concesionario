package com.dam.concesionario.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "dam_coches")
@Data @AllArgsConstructor @NoArgsConstructor
public class Coche implements Serializable{

	/** SERIAL ID */
	private static final long serialVersionUID = 1L;

	/** Identificador del vehículo (PK) */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/** Matrícula del vehículo */
	
	@Size(max=8)
	@Column(name = "Matricula", nullable = false)
	private String matricula;

	/** Marca del vehículo */
	@Size(max=10)
	@Column(name = "Marca", nullable = false)
	private String marca;

	/** Modelo del vehículo */
	@Size(max=10)
	@Column(name = "Modelo", nullable = false)
	private String modelo;
	
}
