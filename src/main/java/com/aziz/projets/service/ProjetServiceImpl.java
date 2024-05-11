package com.aziz.projets.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.aziz.projets.entities.Domaine;
import com.aziz.projets.entities.Projet;
import com.aziz.projets.repos.DomaineRepository;
import com.aziz.projets.repos.ProjetRepository;

@Service
public class ProjetServiceImpl implements ProjetService{

	@Autowired
	ProjetRepository projetRepository;
	
	
	@Autowired
	DomaineRepository domaineRepository;
	
	@Override
	public Projet saveProjet(Projet p) {
		return projetRepository.save(p);
	}

	@Override
	public Projet updateProjet(Projet p) {
		return projetRepository.save(p);
	}

	@Override
	public void deleteProjet(Projet p) {
		projetRepository.delete(p);
		
	}

	@Override
	public void deleteProjetById(Long id) {
		projetRepository.deleteById(id);
		
	}

	@Override
	public Projet getProjet(Long id) {
		return projetRepository.findById(id).get();
	}

	@Override
	public List<Projet> getAllProjets() {
		
		return projetRepository.findAll();
	}
	
	@Override
	public Page<Projet> getAllProjetsParPage(int page, int size) {
		
		return projetRepository.findAll(PageRequest.of(page, size));
	}

	@Override
	public List<Domaine> getAllDomaines() {
		return domaineRepository.findAll();
	}

	
	

}
