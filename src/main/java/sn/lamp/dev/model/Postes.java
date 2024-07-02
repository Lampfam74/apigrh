package sn.lamp.dev.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
@Entity
@Table
@Schema(description = "Postes Model")
public class Postes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String libelle;
	@NotBlank
	private String cotisation;
	public Postes() {
		// TODO Auto-generated constructor stub
	}
	
	public Postes(String libelle, String cotisation) {
		super();
		this.libelle = libelle;
		this.cotisation = cotisation;
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
	public String getCotisation() {
		return cotisation;
	}
	public void setCotisation(String cotisation) {
		this.cotisation = cotisation;
	}
	
	
}
