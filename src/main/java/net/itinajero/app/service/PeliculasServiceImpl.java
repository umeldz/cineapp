package net.itinajero.app.service;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import net.itinajero.app.model.Pelicula;

@Service
public class PeliculasServiceImpl implements IPeliculasService {

	private List<Pelicula> lista = null;

	public PeliculasServiceImpl() {
		
		//System.out.println("Creando una instancia de clase PeliculasServiceImpl");
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

		try {
			lista = new LinkedList<>();

			Pelicula pelicula1 = new Pelicula();
			pelicula1.setId(1);
			pelicula1.setTitulo("Power Rangers");
			pelicula1.setDuracion(120);
			pelicula1.setClasificacion("B");
			pelicula1.setGenero("Aventura");
			// pelicula1.setFechaEstreno(LocalDate.of(2019, 02, 15));
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

		} catch (Exception e) {
			System.out.println("Error" + e.getMessage());

		}
	}

	@Override
	public List<Pelicula> buscarTodas() {
		return lista;
	}

	@Override
	public Pelicula buscarPorId(int idPelicula) {
		
		for(Pelicula p: lista ){	
			if(p.getId()==idPelicula){
				return p;
			}
		}
		return null;
	}

	@Override
	public void insertar(Pelicula pelicula) {
		lista.add(pelicula);
	}

	@Override
	public List<String> buscarGeneros() {
		//Nota : esta lista puede ser generada desde una base de datos
		List<String> generos = new LinkedList<>();
		generos.add("Accion");
		generos.add("Aventura");
		generos.add("Clasicas");
		generos.add("Comedia romantica");
		generos.add("Drama");
		generos.add("Terror");
		generos.add("Infantil");
		generos.add("Accion y Aventura");
		generos.add("Romantica");
		
		return generos;
	}

}
