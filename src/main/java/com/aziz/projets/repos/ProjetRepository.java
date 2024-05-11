package com.aziz.projets.repos;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.aziz.projets.entities.Domaine;
import com.aziz.projets.entities.Projet;

@RepositoryRestResource(path = "rest")
public interface ProjetRepository extends JpaRepository<Projet, Long> {
	
	List<Projet> findByNomProjet(String nom);
	List<Projet> findByNomProjetContains(String nom);
	
	/*@Query("select p from Projet p where p.nomProjet like %?1 and p.Cout > ?2")
	List<Projet> findByNomCout (String nom, Double cout);*/
	
	@Query("select p from Projet p where p.nomProjet like %:nom and p.Cout > :cout")
	List<Projet> findByNomCout (@Param("nom") String nom,@Param("cout") Double cout);

	@Query("select p from Projet p where p.domaine = ?1")
	List<Projet> findByDomaine (Domaine domaine);
	
	List<Projet> findByDomaineIdDom(Long id);
	
	List<Projet> findByOrderByNomProjetAsc();
	
	@Query("select p from Projet p order by p.nomProjet ASC, p.Cout DESC")
	List<Projet> trierProjetsNomsCout ();

}
