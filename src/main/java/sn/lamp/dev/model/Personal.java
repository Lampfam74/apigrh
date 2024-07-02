package sn.lamp.dev.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotBlank;
@Entity
@Table
@Schema(description = "Personal Model")
public class Personal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String prenom;
	@NotBlank
	private String nom;
	@NotBlank
	private String email;
	@NotBlank
	private String genre;
	@NotBlank
	private String token;
	@NotBlank
	private Date dateNaissance;
	@NotBlank
	private String diplome;
	@NotBlank
	private String CV;
	@Transient
	private List<MultipartFile> files=new ArrayList<MultipartFile>();
	public Personal() {
		// TODO Auto-generated constructor stub
	} 

	public Personal(String prenom, String nom, String email, String genre, String token, Date dateNaissance,
			String diplome, String CV) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.email = email;
		this.genre = genre;
		this.token = token;
		this.dateNaissance = dateNaissance;
		this.diplome = diplome;
		this.CV =CV;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public String getDiplome() {
		return diplome;
	}
	public void setDiplome(String diplome) {
		this.diplome = diplome;
	}
	public String getCV() {
		return CV;
	}
	public void setCV(String CV) {
		this.CV = CV;
	}

	public List<MultipartFile> getFiles() {
		return files;
	}

	public void setFiles(List<MultipartFile> files) {
		this.files = files;
	}
	
}

