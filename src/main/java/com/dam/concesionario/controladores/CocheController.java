package com.dam.concesionario.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dam.concesionario.entidades.Coche;
import com.dam.concesionario.servicios.CocheServiceI;

@Controller
public class CocheController {

	@Autowired
	private CocheServiceI cocheServiceI;
	
	
	@RequestMapping("/home")
	@ResponseBody
	public String home() {
		return "hello world";
	}
	
	@GetMapping("/showCarsView")
	public String mostrarCoches(Model model) {

		// Obtención de vehículos
		final List<Coche> listaCoches = cocheServiceI.obtenerTodosCoches();

		// Carga de datos al modelo
		model.addAttribute("carsListView", listaCoches);
		model.addAttribute("btnDropCarEnabled", Boolean.FALSE);

		return "showCars";
	}

	@PostMapping("/actDropCar")
	public String eliminarCoche(@RequestParam String carId, Model model) {

		// Eliminación de vehículo
		cocheServiceI.eliminarCochePorId(Long.valueOf(carId));

		return "redirect:showCarsView";

	}
}
