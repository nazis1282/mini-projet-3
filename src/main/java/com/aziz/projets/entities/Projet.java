package com.aziz.projets.entities;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

@Entity
public class Projet {	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idProjet;
	
	
	@NotNull
	@Size (min = 4,max = 15)
	private String nomProjet;

	private String Manager;
	
	public void setManager(String manager) {
		this.Manager = manager;
	}


	public String getManager() {
		return Manager;
	}


	@Min(value = 10)
    @Max(value = 10000)
	private Double Cout;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@PastOrPresent
	private Date StartDate;
	
	
	@ManyToOne
	private Domaine domaine;



	public Projet() {
		super();
	}
	
	
	public Projet(String nomProjet, String Manager,Double Cout, Date StartDate) {
		super();
		this.nomProjet = nomProjet;
		this.Manager=Manager;
		this.Cout = Cout;
		this.StartDate = StartDate;
	}


	public Long getIdProjet() {
		return idProjet;
	}
	public void setIdProjet(Long idProjet) {
		this.idProjet = idProjet;
	}
	public String getNomProjet() {
		return nomProjet;
	}
	public void setNomProjet(String nomProjet) {
		this.nomProjet = nomProjet;
	}
	public Double getCout() {
		return Cout;
	}
	public void setCout(Double Cout) {
		this.Cout = Cout;
	}
	public Date getStartDate() {
		return StartDate;
	}
	public void setStartDate(Date StartDate) {
		this.StartDate = StartDate;
	}

	

	public Domaine getDomaine() {
		return domaine;
	}


	public void setDomaine(Domaine domaine) {
		this.domaine = domaine;
	}


	@Override
	public String toString() {
		return "Projet [idProjet=" + idProjet + ", nomProjet=" + nomProjet + ", Cout=" + Cout
				+ ", StartDate=" + StartDate + "]";
	}
	
	

}
