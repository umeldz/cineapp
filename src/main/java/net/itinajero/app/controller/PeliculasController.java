package net.itinajero.app.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
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
	public String guardar(Pelicula pelicula, BindingResult result, RedirectAttributes attributes,
			@RequestParam("archivoImagen") MultipartFile multipart, HttpServletRequest request) {

		if (result.hasErrors()) {
			System.out.println("existieron errores");
			return "peliculas/formPelicula";
		}
	
		
		if(!multipart.isEmpty()){
			String nombreImagen = guardarImagen(multipart, request);
			pelicula.setImagen(nombreImagen);
		}
		
		servicePelicula.insertar(pelicula);
		
		attributes.addFlashAttribute("mensaje","El registro fue guardado");
		//return "peliculas/formPelicula";
		return "redirect:/peliculas/index";
	}
	
	private String guardarImagen(MultipartFile multipart, HttpServletRequest request){
		//Se obtiene el nombre del archivo original
		String nombreOriginal= multipart.getOriginalFilename();
		//Se obtiene la ruta absoluta del directorio imagenes
		// apache-tomcat/webapps/cineapp/resources/images
		String rutaFinal= request.getServletContext().getRealPath("/resources/images/");
		
		try {
			//Se forma el nombre del archivo para guardarlo
			File imageFile= new File(rutaFinal + nombreOriginal);
			//Se guarda fisicamente el archivo en el disco duro
			multipart.transferTo(imageFile);
			return nombreOriginal;
			
		} catch (Exception e) {
			System.out.println("Error " + e.getMessage());
			return null;
		}

	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

}
