package com.adaming.gestiondescomptes.entitis;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jdk.nashorn.internal.objects.annotations.Setter;
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING)
@Table(name = "tbCompte")
public class Compte {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	protected Long numeroCompte;
	protected double soldeCompte;
	protected Date dateDeCreation;
	@ManyToOne
	@JoinColumn(name="IDCLIENT")
	private Client client;
	@ManyToOne
	@JoinColumn(name="IDEMPLYE")
	private Employe employe;
	@OneToMany(mappedBy="compte")
	private List<Operation> operations = new ArrayList<Operation>();
	
	@ManyToMany(mappedBy = "tabComptes")
	private Collection<Banque> banques ;
	
	@JsonIgnore
	public Collection<Banque> getBanques() {
		return banques;
	}
	@Setter
	public void setBanques(Collection<Banque> banques) {
		this.banques = banques;
	}
	@JsonIgnore
	public List<Operation> getOperations() {
		return operations;
	}
	@Setter
	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}
	public Employe getEmploye() {
		return employe;
	}
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Long getNumeroCompte() {
		return numeroCompte;
	}
	public void setNumeroCompte(Long numeroCompte) {
		this.numeroCompte = numeroCompte;
	}
	public double getSoldeCompte() {
		return soldeCompte;
	}
	public void setSoldeCompte(double soldeCompte) {
		this.soldeCompte = soldeCompte;
	}
	public Date getDateDeCreation() {
		return dateDeCreation;
	}
	public void setDateDeCreation(Date dateDeCreation) {
		this.dateDeCreation = dateDeCreation;
	}
	
	public Compte() {
	}
	public Compte(double soldeCompte, Date dateDeCreation) {
		super();
		this.soldeCompte = soldeCompte;
		this.dateDeCreation = dateDeCreation;
	}
	
	
}
