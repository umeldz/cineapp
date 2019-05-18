package net.itinajero.app.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.itinajero.app.model.Noticia;

@Repository
//public interface NoticiasRepository extends CrudRepository<Noticia, Integer> {   //extends CrudRepository
public interface NoticiasRepository extends JpaRepository<Noticia, Integer> {     //extends JpaRepository

	// select * from Noticias
	List<Noticia> findBy();
	
	// select * from Noticias where estatus = ?
	List<Noticia> findByEstatus(String estatus);
	
	// where fecha = ?
	List<Noticia> findByFecha(Date date);
	
	//where estatus=? and fecha?
	List<Noticia> findByEstatusAndFecha(String estatus, Date date);
	
	//where estatus=? or fecha?
	List<Noticia> findByEstatusOrFecha(String estatus, Date date);
	
	//where fecha between ? and ?
	List<Noticia> findByFechaBetween(Date inicio, Date fin);
	
	
	//where fecha between ? and ?
	List<Noticia> findByIdBetween(int n1, int n2);
	
	
}
