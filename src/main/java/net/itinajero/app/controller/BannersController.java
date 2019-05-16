package net.itinajero.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.itinajero.app.model.Banner;
import net.itinajero.app.service.IBannersService;
import net.itinajero.app.util.Utileria;

@Controller
@RequestMapping("/banners/")

public class BannersController {

	@Autowired
	private IBannersService serviceBanners;
	
	@GetMapping("/index")
	public String mostrarIndex(Model model){
		
		List<Banner> lista = serviceBanners.buscarTodos();
		model.addAttribute("banners" , lista);
		
		return "banners/listBanners";
	}
	
	@GetMapping("/create")
	public String crear(){
		
		return "banners/formBanner";
	}
	
	@PostMapping("/save")
	
	public String guardar(Banner banner,BindingResult result, RedirectAttributes attributes,
			@RequestParam("archivoImagen") MultipartFile multipart, HttpServletRequest request) {

		if (result.hasErrors()) {
			System.out.println("existieron errores");
			return "banner/formBanner";
		}
		
		if(!multipart.isEmpty()){
			String nombreImagen = Utileria.guardarImagen(multipart, request);
			banner.setArchivo(nombreImagen);
		}
		serviceBanners.insertar(banner);
		attributes.addFlashAttribute("mensaje","El Banner fue guardado");
		return "redirect:/banners/index";
	}
}
