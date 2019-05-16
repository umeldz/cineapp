package net.itinajero.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.itinajero.app.model.Banner;
import net.itinajero.app.model.Pelicula;
import net.itinajero.app.service.IBannersService;
import net.itinajero.app.service.INoticiasService;
import net.itinajero.app.service.IPeliculasService;
import net.itinajero.app.util.Utileria;

@Controller
public class HomeController {
	
	@Autowired
	private IPeliculasService servicePeliculas;
	
	/*
	 * Inyeccion clase de servicio banners
	 */
	@Autowired
	private IBannersService serviceBanners;
	
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String goHome() {
		return "home";
	}

	@RequestMapping(value ="/search", method = RequestMethod.POST)
	public String buscar(@RequestParam("fecha") String fecha, Model model){
		
		List<String> listaFechas = Utileria.getNextDays(4);
		
		List<Banner> listaBanners = serviceBanners.buscarTodos();
		
		List<Pelicula> listaPeliculas = servicePeliculas.buscarTodas();
		model.addAttribute("fechas", listaFechas);
		model.addAttribute("fechaBusqueda", fecha);
		model.addAttribute("peliculas",listaPeliculas);
		model.addAttribute("banners", listaBanners); //Agregar al modelo la lista de banners
		
		
		return "home";
	}
	//@RequestMapping(value = "/detail/{id}/{fecha}",method=RequestMethod.GET)
	@RequestMapping(value = "/detail",method=RequestMethod.GET)
	//public String mostrarDetalle(Model model, @PathVariable("id") int idPelicula, @PathVariable("fecha") String fecha)
	public String mostrarDetalle(Model model, @RequestParam("idMovie") int idPelicula, @RequestParam("fecha") String fecha) {
		
		System.out.println("Buscando Horarios para la pelicula " + idPelicula);
		System.out.println("Para la fecha " + fecha);
		
		model.addAttribute("pelicula",servicePeliculas.buscarPorId(idPelicula));
		
		// TODO - Buscar en la base de datos los horarios		

		return "detalle";
	}
	


	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String mostrarPrincipal(Model model) {
		
		List<String> listaFechas = Utileria.getNextDays(4);
		List<Pelicula> peliculas =servicePeliculas.buscarTodas();
		List<Banner> listaBanners = serviceBanners.buscarTodos();
		
		// peliculas.add("Rapido y furioso");
		// peliculas.add("El aro 2");
		// peliculas.add("Alien");
		
		model.addAttribute("fechaBusqueda", dateFormat.format(new Date()));
		model.addAttribute("peliculas", peliculas);
		model.addAttribute("fechas", listaFechas);
		model.addAttribute("banners", listaBanners); //agregar la lista de banners al modelo
		
		return "home";
	}



}
