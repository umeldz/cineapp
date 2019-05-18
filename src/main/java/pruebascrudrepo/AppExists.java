package pruebascrudrepo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.itinajero.app.repository.NoticiasRepository;

public class AppExists {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);
		
		//Metodo para verificar si una entodad existe en la base de datos (metodo existsById)
		
		int idNoticia=10;
		System.out.println(repo.existsById(idNoticia));
		
		context.close();

	}

}
