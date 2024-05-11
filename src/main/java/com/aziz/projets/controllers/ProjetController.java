package com.aziz.projets.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aziz.projets.entities.Domaine;
import com.aziz.projets.entities.Projet;
import com.aziz.projets.service.ProjetService;

import jakarta.validation.Valid;

@Controller
public class ProjetController {
	@Autowired
	ProjetService projetService;
	
	
		   @RequestMapping("/ListeProjets")
			public String listeProjets(ModelMap modelMap,@RequestParam (name="page",defaultValue = "0") int page,
										@RequestParam (name="size", defaultValue = "2") int size)
			{
			Page<Projet> prods = projetService.getAllProjetsParPage(page, size);
				modelMap.addAttribute("projets", prods);
		         modelMap.addAttribute("pages", new int[prods.getTotalPages()]);	
				modelMap.addAttribute("currentPage", page);			
				return "listeProjets";	
			}


		   @RequestMapping("/showCreate")
			public String showCreate(ModelMap modelMap)
			{
				modelMap.addAttribute("projet", new Projet());
				List<Domaine> doms = projetService.getAllDomaines();
				modelMap.addAttribute("mode", "new");
				modelMap.addAttribute("domaines", doms);
				return "formProjet";
			}
		   
		   
			


		   @RequestMapping("/saveProjet")
			public String saveProjet(@Valid Projet projet, BindingResult bindingResult,
					@RequestParam (name="page",defaultValue = "0") int page,
					@RequestParam (name="size", defaultValue = "2") int size)
			{
				int currentPage;
				boolean isNew = false;
			   if (bindingResult.hasErrors()) return "formProjet";				  
				
			   if(projet.getIdProjet()==null) //ajout
				    isNew=true;
			  			   
			  	projetService.saveProjet(projet);
			  	if (isNew) //ajout
			  	{
			  		Page<Projet> prods = projetService.getAllProjetsParPage(page, size);
			  		currentPage = prods.getTotalPages()-1;
			  	}
			  	else //modif
			  		currentPage=page;
			  	
			  	
				//return "formProjet";
				return ("redirect:/ListeProjets?page="+currentPage+"&size="+size);
			}


	  @RequestMapping("/supprimerProjet")
		public String supprimerProjet(@RequestParam("id") Long id,
				ModelMap modelMap,
				@RequestParam (name="page",defaultValue = "0") int page,
				@RequestParam (name="size", defaultValue = "2") int size)
		{

			projetService.deleteProjetById(id);
			Page<Projet> prods = projetService.getAllProjetsParPage(page, size);
			modelMap.addAttribute("projets", prods);		
			modelMap.addAttribute("pages", new int[prods.getTotalPages()]);	
			modelMap.addAttribute("currentPage", page);	
			modelMap.addAttribute("size", size);	
			return "listeProjets";	
		}


	@RequestMapping("/modifierProjet")
	public String editerProjet(@RequestParam("id") Long id, ModelMap modelMap,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "2") int size) {
		Projet p = projetService.getProjet(id);
		List<Domaine> doms = projetService.getAllDomaines();
		modelMap.addAttribute("mode", "edit");
		modelMap.addAttribute("projet", p);
		modelMap.addAttribute("domaines", doms);
		modelMap.addAttribute("page", page);
		modelMap.addAttribute("size", size);
		
		return "formProjet";
	}
	  
	

	@RequestMapping("/updateProjet")
	public String updateProjet(@ModelAttribute("projet") Projet projet, @RequestParam("date") String date,
			ModelMap modelMap) throws ParseException {
		// conversion de la date
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateCreation = dateformat.parse(String.valueOf(date));
		projet.setStartDate(dateCreation);

		projetService.updateProjet(projet);
		List<Projet> prods = projetService.getAllProjets();
		modelMap.addAttribute("projets", prods);
		return "listeProjets";
	}

	@GetMapping(value = "/")
	public String welcome() {
 	return "index";
	}

}
