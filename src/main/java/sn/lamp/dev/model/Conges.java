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
@Schema(description = "Conges Model")
public class Conges {
	   @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
	   @NotBlank
		private String libelle;
	   @NotBlank
		private String nature;
	   @NotBlank
		private String type;
	   @NotBlank
		private String personal_id;
	   @NotBlank
		private String statut;
	   @NotBlank
		private Date debut;
	   @NotBlank
		private Date fin;
	   @NotBlank
		private String demande;
		@Transient
		private List<MultipartFile> files=new ArrayList<MultipartFile>();
		public Conges() {
			// TODO Auto-generated constructor stub
		}
		public Conges(String libelle, String nature, String type, String personal_id, String statut, Date debut,
				Date fin) {
			super();
			this.libelle = libelle;
			this.nature = nature;
			this.type = type;
			this.personal_id = personal_id;
			this.statut = statut;
			this.debut = debut;
			this.fin = fin;
		}
		public String getLibelle() {
			return libelle;
		}
		public void setLibelle(String libelle) {
			this.libelle = libelle;
		}
		public String getNature() {
			return nature;
		}
		public void setNature(String nature) {
			this.nature = nature;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getPersonal_id() {
			return personal_id;
		}
		public void setPersonal_id(String personal_id) {
			this.personal_id = personal_id;
		}
		public String getStatut() {
			return statut;
		}
		public void setStatut(String statut) {
			this.statut = statut;
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
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getDemande() {
			return demande;
		}
		public void setDemande(String demande) {
			this.demande = demande;
		}
		public List<MultipartFile> getFiles() {
			return files;
		}
		public void setFiles(List<MultipartFile> files) {
			this.files = files;
		}
		
		
		
}
