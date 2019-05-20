package net.itinajero.app.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.itinajero.app.model.Pelicula;
import net.itinajero.app.repository.PeliculasRepository;


@Service
public class PeliculasServiceJPA implements IPeliculasService{
	
	
	
	@Autowired  //Inyeccion de dependencias de Spring
	private PeliculasRepository peliculasRepo;

	@Override
	public void insertar(Pelicula pelicula) {
		peliculasRepo.save(pelicula);
	}

	@Override
	public List<Pelicula> buscarTodas() {
		
		return peliculasRepo.findAll();
	}

	@Override
	public Pelicula buscarPorId(int idPelicula) {
		Optional<Pelicula> optional= peliculasRepo.findById(idPelicula);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
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

	@Override
	public void eliminar(int idPelicula) {
		peliculasRepo.deleteById(idPelicula);
	}

	
}
