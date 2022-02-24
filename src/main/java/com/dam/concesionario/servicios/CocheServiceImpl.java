package com.dam.concesionario.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dam.concesionario.entidades.Coche;
import com.dam.concesionario.repositorio.CocheRepositorioI;

@Service
public class CocheServiceImpl implements CocheServiceI{

	@Autowired
	private CocheRepositorioI cocheRepositorio;
	
	@Override
	public List<Coche> obtenerTodosCoches() {
		return cocheRepositorio.findAll();
	}


	@Override
	public void eliminarCochePorId(long IdCoche) {
		cocheRepositorio.deleteById(IdCoche);	
	}

	@Override
	public Coche aniadirCoche(Coche coche) {
		return cocheRepositorio.save(coche);	
	}

	@Override
	public void actualizarCoche(Coche coche) {
		cocheRepositorio.save(coche);
	}

	@Override
	public Optional<Coche> obtenerCoche(Long id) {
		
		return cocheRepositorio.findById(id);
		 
	}

	@Override
	public boolean existeCochePorId(Long id) {
		return cocheRepositorio.existsById(id);
		
	}

}
