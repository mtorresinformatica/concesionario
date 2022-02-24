package com.dam.concesionario.servicios;

import java.util.List;
import java.util.Optional;

import com.dam.concesionario.entidades.Coche;

public interface CocheServiceI {

	public List<Coche> obtenerTodosCoches();
	
	public Optional<Coche> obtenerCoche(final Long id);
	
	public void eliminarCochePorId(final long IdCoche);

	public Coche aniadirCoche(final Coche coche);

	public void actualizarCoche(final Coche coche);
	
	public boolean existeCochePorId(final Long id);
	
	
}
