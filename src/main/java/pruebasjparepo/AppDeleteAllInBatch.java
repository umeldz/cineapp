package pruebasjparepo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.itinajero.app.repository.NoticiasRepository;

public class AppDeleteAllInBatch {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);
		
		/*
		 * Metodo deleteAllInBatch de la interfaz JpaRepository -> (es m�s eficiente)
		 *  delete from noticias
		 */

		repo.deleteAllInBatch();
		
		context.close();
	}

}
