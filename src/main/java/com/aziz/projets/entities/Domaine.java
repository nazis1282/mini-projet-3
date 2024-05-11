package com.aziz.projets.entities;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Domaine {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDom;
	private String nomDom;
	private String descriptionDom;
	
	@JsonIgnore
	@OneToMany(mappedBy = "domaine")
	private List<Projet> produits;
}
