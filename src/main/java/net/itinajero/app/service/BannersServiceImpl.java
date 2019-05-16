package net.itinajero.app.service;

import java.text.SimpleDateFormat;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import net.itinajero.app.model.Banner;

@Service
public class BannersServiceImpl implements IBannersService {

	List<Banner> lista;

	public BannersServiceImpl() {

		;

		try {
			lista = new LinkedList();
			
			Banner b1 = new Banner();
			b1.setId(1);
			b1.setEstatus("Activo");
			b1.setTitulo("Pelicula 1");
			b1.setArchivo("slide1.jpg");
			
			Banner b2 = new Banner();
			b2.setId(2);
			b2.setEstatus("Activo");
			b2.setTitulo("Pelicula 2");
			b2.setArchivo("slide2.jpg");
			
			Banner b3 = new Banner();
			b3.setId(3);
			b3.setEstatus("Activo");
			b3.setTitulo("Pelicula 3");
			b3.setArchivo("slide3.jpg");
			
			Banner b4 = new Banner();
			b4.setId(4);
			b4.setEstatus("Activo");
			b4.setTitulo("Pelicula 4");
			b4.setArchivo("slide4.jpg");
			
			lista.add(b1);
			lista.add(b2);
			lista.add(b3);
			lista.add(b4);

		} catch (Exception e) {
			System.out.println("Exeption " + e);
		}
	}

	@Override
	public void insertar(Banner banner) {
		lista.add(banner);

	}

	@Override
	public List<Banner> buscarTodos() {
		return lista;
	}

}
