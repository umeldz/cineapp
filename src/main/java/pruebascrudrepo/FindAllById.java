package pruebascrudrepo;

import java.util.LinkedList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.itinajero.app.model.Noticia;
import net.itinajero.app.repository.NoticiasRepository;

public class FindAllById {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);
		
		//Recuperar varios registros por el Id [metodo findAllById del repositorio]
		List<Integer> ids = new LinkedList<Integer>();
		ids.add(3);
		ids.add(4);
		ids.add(5);
		ids.add(6);
		ids.add(7);
		
		Iterable<Noticia> noticias = repo.findAllById(ids);
		
		for(Noticia n: noticias ){
			System.out.println(n);
			
		}
		
		context.close();

	}

}
