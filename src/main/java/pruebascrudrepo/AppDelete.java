package pruebascrudrepo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.itinajero.app.repository.NoticiasRepository;

public class AppDelete {
	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);

		//Operacion CRUD - Delete [Metodo deleteById del repositorio]
		
		int idNoticia=1;
		
		//repo.deleteById(idNoticia);
		if(repo.existsById(idNoticia)){
			repo.deleteById(idNoticia);
		}
		context.close();
	}
}
