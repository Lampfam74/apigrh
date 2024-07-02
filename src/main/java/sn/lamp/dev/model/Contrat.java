package sn.lamp.dev.model;

import java.sql.Date;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table
@Schema(description = "Contrat model")
public class Contrat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    @NotBlank
	private String libelle;
    @NotBlank
	private String Categorie_id;
    @NotBlank
	private String poste_id;
    @NotBlank
	private String personal_id;
    @NotBlank
	private Double salaire;
    @NotBlank
	private Date debut;
    @NotBlank
	private Date fin;
	
	public Contrat() {
		// TODO Auto-generated constructor stub
	}
	

	public Contrat(String libelle, String categorie_id, String poste_id, String personal_id, Double salaire, Date debut,
			Date fin) {
		super();
		this.libelle = libelle;
		Categorie_id = categorie_id;
		this.poste_id = poste_id;
		this.personal_id = personal_id;
		this.salaire = salaire;
		this.debut = debut;
		this.fin = fin;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getCategorie_id() {
		return Categorie_id;
	}
	public void setCategorie_id(String categorie_id) {
		Categorie_id = categorie_id;
	}
	public String getPoste_id() {
		return poste_id;
	}
	public void setPoste_id(String poste_id) {
		this.poste_id = poste_id;
	}
	public String getPersonal_id() {
		return personal_id;
	}
	public void setPersonal_id(String personal_id) {
		this.personal_id = personal_id;
	}
	public Double getSalaire() {
		return salaire;
	}
	public void setSalaire(Double salaire) {
		this.salaire = salaire;
	}


	public Date getDebut() {
		return debut;
	}


	public void setDebut(Date debut) {
		this.debut = debut;
	}


	public Date getFin() {
		return fin;
	}


	public void setFin(Date fin) {
		this.fin = fin;
	}
	
	
}
