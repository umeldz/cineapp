
/**
 * Clase para representar una imagen del Banner (Carousel) de la página principal
 */
package net.itinajero.app.model;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class Banner {
	
	private int id;
	private String titulo;
	private LocalDate fecha;
	private String archivo;
	private String estatus;
	
	

	public Banner(){
		this.fecha= LocalDate.now();
		this.estatus= "Activo";
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public LocalDate getFecha() {
		return fecha;
	}


	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}


	public String getArchivo() {
		return archivo;
	}


	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}


	public String getEstatus() {
		return estatus;
	}


	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	
	
}
