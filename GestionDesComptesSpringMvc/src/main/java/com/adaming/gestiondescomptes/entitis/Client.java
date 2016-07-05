package com.adaming.gestiondescomptes.entitis;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jdk.nashorn.internal.objects.annotations.Setter;
@Entity
@Table(name ="tbClient")
public class Client {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idClient;
    @NotEmpty(message = "Merci de renseigner le nom")
    @Size(min=4,max=20)
	private String nomClient;
	@NotEmpty(message = "Merci de renseigner le prenom")
	@Size(min=4,max=20)
	private String prenomClient;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "Merci de renseigner la date")
	private Date dateDeNaissance;
	@NotEmpty(message = "Merci de renseigner l'address du client")
	@Size(min=10)
	private String addrPosta;
	@OneToMany(mappedBy="client")
	private List<Compte> comptes = new ArrayList<Compte>();
	
	public Long getIdClient() {
		return idClient;
	}
	@JsonIgnore
	public List<Compte> getComptes() {
		return comptes;
	}
	@Setter
	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}
	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}
	public String getNomClient() {
		return nomClient;
	}
	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}
	public String getPrenomClient() {
		return prenomClient;
	}
	public void setPrenomClient(String prenomClient) {
		this.prenomClient = prenomClient;
	}
	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}
	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}
	public String getAddrPosta() {
		return addrPosta;
	}
	public void setAddrPosta(String addrPosta) {
		this.addrPosta = addrPosta;
	}
	
	public Client() {
	}
	public Client(String nomClient, String prenomClient, Date dateDeNaissance,
			String addrPosta) {
		super();
		this.nomClient = nomClient;
		this.prenomClient = prenomClient;
		this.dateDeNaissance = dateDeNaissance;
		this.addrPosta = addrPosta;
	}
	
	
}
