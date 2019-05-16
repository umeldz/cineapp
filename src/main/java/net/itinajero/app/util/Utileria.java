/**
 * 
 */
package net.itinajero.app.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;



/**
 * @author Uriel
 *
 */
public class Utileria {

	
	public static List<String> getNextDays(int count){
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		//Today Date
		Date start = new Date();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, count); // Next N days from Now
		Date endDate = cal.getTime();
		
		GregorianCalendar gcal = new GregorianCalendar();
		gcal.setTime(start);
		List<String> nextDays = new ArrayList<String>();
		while (!gcal.getTime().after(endDate)) {
			Date d = gcal.getTime();
			gcal.add(Calendar.DATE, 1);
			nextDays.add(sdf.format(d));
			
		}
		
		return nextDays;
	}
	
	public static String guardarImagen(MultipartFile multipart, HttpServletRequest request){
		//Se obtiene el nombre del archivo original
		String nombreOriginal= multipart.getOriginalFilename();
		nombreOriginal= nombreOriginal.replace(" ", "-");
		
		//Generar nombre con caracteres ramdom para que no se repitan
		String nombreFinal=Utileria.randomAlphaNumeric(8) + nombreOriginal;

		//Se obtiene la ruta absoluta del directorio imagenes
		// apache-tomcat/webapps/cineapp/resources/images
		String rutaFinal= request.getServletContext().getRealPath("/resources/images/");
		
		try {
			//Se forma el nombre del archivo para guardarlo
			File imageFile= new File(rutaFinal + nombreFinal);
			
			//Se guarda fisicamente el archivo en el disco duro
			multipart.transferTo(imageFile);
			
			return nombreFinal;
			
		} catch (Exception e) {
			System.out.println("Error " + e.getMessage());
			return null;
		}

	}
	
	//Metodo para generar una cadena de longitud N de caracteres aleatorios
	public static String randomAlphaNumeric(int count){
		String CARACTERES ="ABCDEFGJIJKLMOPQRSTUVWXYZ0123456789";
		StringBuilder builder= new StringBuilder();
		while (count-- !=0) {
			int character =(int)(Math.random()*CARACTERES.length());
			builder.append(CARACTERES.charAt(character));
			
		}
		
		return builder.toString();
	}
}
