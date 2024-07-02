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
@Schema(description = "HeureSup model")
public class HeureSup {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String libelle;
	@NotBlank
	private Double prime;
	public HeureSup() {
		// TODO Auto-generated constructor stub
	}
	
	public HeureSup(String libelle, Double prime) {
		super();
		this.libelle = libelle;
		this.prime = prime;
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
	public Double getPrime() {
		return prime;
	}
	public void setPrime(Double prime) {
		this.prime = prime;
	}
	
}
