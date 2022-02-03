package com.dam.concesionario.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "dam_coches")
class Coche {

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


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	@Override
	public String toString() {
		return "Coche [id=" + id + ", matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + "]";
	}
	
}
