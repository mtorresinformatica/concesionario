package com.dam.concesionario.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dam.concesionario.entidades.*;

@Repository
public interface CocheRepositorioI extends JpaRepository<Coche, Long> {
	
	List<Coche> findByMatricula(String matricula);
	
	List <Coche> findByMarcaOrModelo(final String Marca, final String Modelo);
	
	List <Coche> findByMarcaAndModelo(final String Marca, final String Modelo);
	
}
