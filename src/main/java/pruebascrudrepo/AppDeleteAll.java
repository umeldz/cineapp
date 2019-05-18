package pruebascrudrepo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.itinajero.app.repository.NoticiasRepository;

public class AppDeleteAll {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);
		
		//Borrar todos los registros [metodo deleteAll del repositorio]
		//Metodo ¡Peligroso!
		repo.deleteAll();
		
		context.close();
	}

}
