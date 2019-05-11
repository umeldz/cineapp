package net.itinajero.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.itinajero.app.model.Noticia;
import net.itinajero.app.service.INoticiasService;

@Controller


@RequestMapping("/noticias")
public class NoticiasController {
	
	@Autowired
	private INoticiasService serviceNoticias;
	
	@GetMapping(value="/create")
	public String crear(){

		return "noticias/formNoticias";
	}
	
	//Utilización de Data Binding 
	//solo se necesita pasar el objeto y Spring extrae los atributos 
	@PostMapping(value="/save")
	public String guardar(Noticia noticia){
			
		serviceNoticias.guardar(noticia);
		//Pendiente : Guardar el objeto noticia en la BD
		return "noticias/formNoticias";
	}

}
