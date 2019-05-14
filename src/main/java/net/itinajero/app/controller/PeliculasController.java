package net.itinajero.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.itinajero.app.model.Pelicula;
import net.itinajero.app.service.IPeliculasService;

@Controller

@RequestMapping("/peliculas")
public class PeliculasController {

	@Autowired
	private IPeliculasService servicePelicula;
	
	
	@GetMapping("/index")
	public String mostrarIndex(Model model){
		
		List<Pelicula> lista = servicePelicula.buscarTodas();
		model.addAttribute("peliculas", lista);
		
		return "peliculas/listPeliculas";
	}
	
	@GetMapping("/create")
	public String crear() {

		
		return "peliculas/formPelicula";
	}

	@PostMapping("/save")
	public String guardar(Pelicula pelicula, BindingResult result, RedirectAttributes attributes) {

		if (result.hasErrors()) {
			System.out.println("existieron errores");
			return "peliculas/formPelicula";
		}
		System.out.println("elementos de la lista antes: " + servicePelicula.buscarTodas().size());
		
		servicePelicula.insertar(pelicula);
		System.out.println("elementos de la lista despues de insertar: " + servicePelicula.buscarTodas().size());
		System.out.println("Guardando pelicula" + pelicula);
		
		attributes.addFlashAttribute("mensaje","El registro fue guardado");
		//return "peliculas/formPelicula";
		return "redirect:/peliculas/index";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

}
