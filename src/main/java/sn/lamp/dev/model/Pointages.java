package sn.lamp.dev.model;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
@Entity
@Table
@Schema(description = "Pointages Model")
public class Pointages {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String type;
	@NotBlank
	private Date date;
	@NotBlank
	private Time entree;
	@NotBlank
	private Time sortie;
	@NotBlank
	private String token; 
	public Pointages() {
		// TODO Auto-generated constructor stub
	}
	public Pointages(String type, Date date, Time entree, String token) {
		super();
		this.type = type;
		this.date = date;
		this.entree = entree;
		this.token = token;
	}



    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Time getEntree() {
		return entree;
	}
	public void setEntree(Time entree) {
		this.entree = entree;
	}
	public Time getSortie() {
		return sortie;
	}
	public void setSortie(Time sortie) {
		this.sortie = sortie;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
}
