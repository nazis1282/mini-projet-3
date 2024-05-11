package com.aziz.projets;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.aziz.projets.entities.Projet;
import com.aziz.projets.service.ProjetService;

@SpringBootApplication
public class ProjetsApplication implements CommandLineRunner  {
	
	@Autowired 
	ProjetService produitService;

	public static void main(String[] args) {
		SpringApplication.run(ProjetsApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
	
	}

}
