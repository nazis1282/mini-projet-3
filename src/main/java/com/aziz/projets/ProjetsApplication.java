package com.aziz.projets;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.aziz.projets.entities.Projet;
import com.aziz.projets.entities.Role;
import com.aziz.projets.entities.User;
import com.aziz.projets.service.ProjetService;
import com.aziz.projets.service.UserService;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class ProjetsApplication implements CommandLineRunner  {
	
	@Autowired 
	ProjetService produitService;

	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	UserService userService;
	public static void main(String[] args) {
		SpringApplication.run(ProjetsApplication.class, args);
	}
		 @PostConstruct
		void init_users() {
			
			//ajouter les rôles
			userService.addRole(new Role(null,"ADMIN"));
			userService.addRole(new Role(null,"AGENT"));
			userService.addRole(new Role(null,"USER"));
			//ajouter les users
			userService.saveUser(new User(null,"admin","123",true,null));
			userService.saveUser(new User(null,"aziz","123",true,null));
			userService.saveUser(new User(null,"user1","123",true,null));
			//ajouter les rôles aux users
			userService.addRoleToUser("admin", "ADMIN");
			userService.addRoleToUser("aziz", "USER");
			userService.addRoleToUser("aziz", "AGENT");
			userService.addRoleToUser("user1", "USER");
			
	}
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Password Encoded BCRYPT :******************** ");
 		System.out.println(passwordEncoder.encode("123"));
		
	
	}

}
