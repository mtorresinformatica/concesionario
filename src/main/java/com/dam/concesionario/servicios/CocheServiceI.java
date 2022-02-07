package com.dam.concesionario.servicios;

import java.util.List;

import com.dam.concesionario.entidades.Coche;

public interface CocheServiceI {

	public List<Coche> obtenerTodosCoches();

	public Coche obtenerCochePorMatricula(final String Matricula);

	public List<Coche> obtenerCochePorMarcaOModelo(final String Marca, final String Modelo);

	public List<Coche> obtenerCochePorMarcaYModelo(final String Marca, final String Modelo);

	public void eliminarCochePorId(final long IdCoche);

	public void aniadirCoche(final Coche coche);

	public void actualizarCoche(final Coche coche);
}
