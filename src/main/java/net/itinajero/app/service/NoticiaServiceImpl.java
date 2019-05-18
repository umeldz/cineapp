package net.itinajero.app.service;

import org.springframework.stereotype.Service;

import net.itinajero.app.model.Noticia;

@Service
public class NoticiaServiceImpl implements INoticiasService{

	
	
	// Constructor vacio. Unicamente para imprimir un mensaje al crearse una instancia
	public NoticiaServiceImpl() {
		//System.out.println("Creando una instancia de la clase NoticiasServiceImpl");
	}
	
	@Override
	public void guardar(Noticia noticia) {
		System.out.println(noticia);
		
	}


}
