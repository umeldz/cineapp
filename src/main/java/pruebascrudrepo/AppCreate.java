package pruebascrudrepo;



import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.itinajero.app.model.Noticia;
import net.itinajero.app.repository.NoticiasRepository;


//Aplicacion para persistir (Crear) en la tabla Noticias un objeto de tipo Noticia
public class AppCreate {

	public static void main(String[] args) {
//		Noticia noticia = new Noticia();
//		noticia.setTitulo("Proximo estreno: Juego Macabro 8");
//		noticia.setDetalle("El mes de septiembre se estrena la nueva pelicula de SAW 8");
//		noticia.setEstatus("Inactiva");
		
		Noticia noticia2 = new Noticia();
		noticia2.setTitulo("Proximo estreno Spider Man - far from home");
		noticia2.setDetalle("El mes de Mayo se estrena esta nueva pelicula");
		noticia2.setEstatus("Activa");
		
/*		Noticia noticia3 = new Noticia();
		noticia3.setTitulo("El vicio del poder");
		noticia3.setDetalle("Una de las grandes contendientes en la temporada de premios norteamericanos, dirigida por Adam McKay y"
				+ " basada en la vida de Dick Cheney, expresidente de los Estados Unidos.");
		noticia3.setEstatus("Activa");
		
		Noticia noticia4 = new Noticia();
		noticia4.setTitulo("Creed II: La leyenda de Rocky");
		noticia4.setDetalle("¡Vuelve Rocky! Y también Adonis Creed, que en la anterior entrega nos demostró que tiene lo que hay que tener para ser un digno heredero del boxeador de Sylvester Stallone. "
				+ "Aquí se enfrentará al pupilo de Ivan Drago, uno de sus mayores competidores.");
		noticia4.setEstatus("Activa");*/
		
		
		
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);
		//repo.save(noticia);
		repo.save(noticia2);
	
		
		
		context.close();
	}

	
}
