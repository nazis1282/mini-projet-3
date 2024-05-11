package com.aziz.projets.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.aziz.projets.entities.Domaine;
import com.aziz.projets.entities.Projet;

public interface ProjetService {
	Projet saveProjet(Projet p);
	Projet updateProjet(Projet p);
	void deleteProjet(Projet p);
	void deleteProjetById(Long id);
	Projet getProjet(Long id);
	List<Projet> getAllProjets();
	
	Page<Projet> getAllProjetsParPage(int page, int size);
	
	List<Domaine> getAllDomaines();
	


}
