package com.dam.concesionario.controladores;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.naming.spi.DirStateFactory.Result;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.dam.concesionario.entidades.Coche;
import com.dam.concesionario.errores.ApiError;
import com.dam.concesionario.errores.CocheNotFoundException;
import com.dam.concesionario.servicios.CocheServiceI;
import com.fasterxml.jackson.databind.JsonMappingException;

import lombok.RequiredArgsConstructor;

@RestController
public class CocheController {

	@Autowired
	private CocheServiceI cocheServiceI;

	//Mostrar todos los coches
	@GetMapping("/mostrarCoches")
	public ResponseEntity<?> mostrarCoches() {
		// Obtención de vehículos
		final List<Coche> listaCoches = cocheServiceI.obtenerTodosCoches();

		if (listaCoches.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No hay productos registrados");
		} else {
			return ResponseEntity.ok(listaCoches);
		}
	}

	//Mostrar coche por id
	@GetMapping("/coche/{id}")
	public Coche mostrarCoche(@PathVariable Long id) {

			return cocheServiceI.obtenerCoche(id).orElseThrow(() -> new CocheNotFoundException(id));

	}

	//Añadir un coche
	@PostMapping("/coche")
	public ResponseEntity<?> aniadirCoche(@RequestBody Coche newCar) throws Exception {

		Coche nuevoCoche = new Coche();
		nuevoCoche.setMatricula(newCar.getMatricula());
		nuevoCoche.setMarca(newCar.getMarca());
		nuevoCoche.setModelo(newCar.getModelo());

		return ResponseEntity.status(HttpStatus.CREATED).body(cocheServiceI.aniadirCoche(newCar));
	}

	//Actualizar coche por id
	@PutMapping("/coche/{id}")
	public Coche actualizarCoche(@RequestBody Coche cocheEditado, @PathVariable Long id) {

		return cocheServiceI.obtenerCoche(id).map(p -> {
			p.setMatricula(cocheEditado.getMatricula());
			p.setMarca(cocheEditado.getMarca());
			p.setModelo(cocheEditado.getModelo());
			return cocheServiceI.aniadirCoche(p);
		}).orElseThrow(() -> new CocheNotFoundException(id));
	}

	//Eliminar coche por id
	@DeleteMapping("/coche/{id}")
	public ResponseEntity<?> eliminarCoche(@PathVariable Long id) {

		Coche coche = cocheServiceI.obtenerCoche(id)
				.orElseThrow(()-> new CocheNotFoundException(id));
		cocheServiceI.eliminarCochePorId(id);
		return ResponseEntity.noContent().build();

	}

}
