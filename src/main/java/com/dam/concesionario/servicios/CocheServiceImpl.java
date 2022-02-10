package com.dam.concesionario.servicios;

import java.util.List;

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
	public Coche obtenerCochePorMatricula(String matricula) {
		final Coche coche = cocheRepositorio.findByMatricula(matricula);
		return coche;
	}

	@Override
	public List<Coche> obtenerCochePorMarcaOModelo(String Marca, String Modelo) {
		return cocheRepositorio.findByMarcaOrModelo(Marca, Modelo);
	}

	@Override
	public List<Coche> obtenerCochePorMarcaYModelo(String Marca, String Modelo) {
		return cocheRepositorio.findByMarcaAndModelo(Marca, Modelo);
	}

	@Override
	public void eliminarCochePorId(long IdCoche) {
		cocheRepositorio.deleteById(IdCoche);	
	}

	@Override
	public void aniadirCoche(Coche coche) {
		cocheRepositorio.save(coche);	
	}

	@Override
	public void actualizarCoche(Coche coche) {
		cocheRepositorio.save(coche);
	}
	
	

}
