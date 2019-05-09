package net.itinajero.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.itinajero.app.model.Pelicula;
import net.itinajero.app.util.Utileria;

@Controller
public class HomeController {

	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String goHome() {
		return "home";
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String buscar(@RequestParam("fecha") String fecha, Model model){
		
		List<String> listaFechas = Utileria.getNextDays(4);
		List<Pelicula> listaPeliculas = getLista();
		model.addAttribute("fechas", listaFechas);
		model.addAttribute("fechaBusqueda", fecha);
		model.addAttribute("peliculas",listaPeliculas);
		
		System.out.println("Buscando todas las peliculas en exhibicion para le fecha " + fecha);
		return "home";
	}
	//@RequestMapping(value = "/detail/{id}/{fecha}",method=RequestMethod.GET)
	@RequestMapping(value = "/detail",method=RequestMethod.GET)
	//public String mostrarDetalle(Model model, @PathVariable("id") int idPelicula, @PathVariable("fecha") String fecha)
	public String mostrarDetalle(Model model, @RequestParam("idMovie") int idPelicula, @RequestParam("fecha") String fecha) {
		
		System.out.println("Buscando Horarios para la pelicula " + idPelicula);
		System.out.println("Para la fecha " + fecha);
		
		// TODO - Buscar en la base de datos los horarios
		
		//String tituloPelicula = "Rapidos y furiosos";
		//int duracion = 136;
		//double precioEntrada = 50;
		//model.addAttribute("titulo", tituloPelicula);
		//model.addAttribute("duracion", duracion);
		//model.addAttribute("precio", precioEntrada);

		return "detalle";
	}
	


	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String mostrarPrincipal(Model model) {
		
		List<String> listaFechas = Utileria.getNextDays(4);
		List<Pelicula> peliculas = getLista();
		
		// peliculas.add("Rapido y furioso");
		// peliculas.add("El aro 2");
		// peliculas.add("Alien");
		
		model.addAttribute("fechaBusqueda", dateFormat.format(new Date()));
		model.addAttribute("peliculas", peliculas);
		model.addAttribute("fechas", listaFechas);
		return "home";
	}

	// Metodo para generar una lista de Objetos de Modelo (Pelicula)
	private List<Pelicula> getLista() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		List<Pelicula> lista = null;

		try {
			lista = new LinkedList<>();

			Pelicula pelicula1 = new Pelicula();
			pelicula1.setId(1);
			pelicula1.setTitulo("Power Rangers");
			pelicula1.setDuracion(120);
			pelicula1.setClasificacion("B");
			pelicula1.setGenero("Aventura");
			//pelicula1.setFechaEstreno(LocalDate.of(2019, 02, 15));
			pelicula1.setFechaEstreno(formatter.parse("02-05-2019"));
			// imagen="cinema.png"
			// estatus activa

			Pelicula pelicula2 = new Pelicula();
			pelicula2.setId(2);
			pelicula2.setTitulo("La bella y la bestia");
			pelicula2.setDuracion(130);
			pelicula2.setClasificacion("A");
			pelicula2.setGenero("Infantil");
			pelicula2.setFechaEstreno(formatter.parse("02-05-2019"));
			pelicula2.setImagen("bella.png");
			// imagen="cinema.png"
			// estatus activa

			Pelicula pelicula3 = new Pelicula();
			pelicula3.setId(3);
			pelicula3.setTitulo("Contratiempo");
			pelicula3.setDuracion(132);
			pelicula3.setClasificacion("B");
			pelicula3.setGenero("Thriller");
			pelicula3.setFechaEstreno(formatter.parse("02-05-2019"));
			pelicula3.setImagen("contratiempo.png");
			// imagen="cinema.png"
			// estatus activa

			Pelicula pelicula4 = new Pelicula();
			pelicula4.setId(4);
			pelicula4.setTitulo("King kong");
			pelicula4.setDuracion(132);
			pelicula4.setClasificacion("B");
			pelicula4.setGenero("Thriller");
			pelicula4.setFechaEstreno(formatter.parse("02-05-2019"));
			pelicula4.setImagen("kong.png");
			pelicula4.setEstatus("Inactiva");
			
			Pelicula pelicula5 = new Pelicula();
			pelicula5.setId(5);
			pelicula5.setTitulo("Life: Vida inteligente");
			pelicula5.setDuracion(160);
			pelicula5.setClasificacion("B");
			pelicula5.setGenero("Thriller");
			pelicula5.setFechaEstreno(formatter.parse("02-05-2019"));
			pelicula5.setImagen("estreno5.png");
			pelicula5.setEstatus("Activa");
			
			// Agregar objetos a la lista
			lista.add(pelicula1);
			lista.add(pelicula2);
			lista.add(pelicula3);
			lista.add(pelicula4);
			lista.add(pelicula5);
			return lista;
			
		} catch (Exception e) {
			System.out.println("Error" + e.getMessage());
			return null;
		}
		

	}

}
