package com.adaming.gestiondescomptes.entitis;

import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jdk.nashorn.internal.objects.annotations.Setter;
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING)
@Table(name ="tbOperation")
public class Operation {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	protected Long idOperation;
	protected double montant;
	protected Date dateDoperation;
	@ManyToOne
	@JoinColumn(name="IDCOMPET")
	private Compte compte;
	@ManyToOne
	@JoinColumn(name="IDEMPLOY")
	private Employe employe;
	
	
	public Employe getEmploye() {
		return employe;
	}
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	public Long getIdOperation() {
		return idOperation;
	}
	public void setIdOperation(Long idOperation) {
		this.idOperation = idOperation;
	}
	@JsonIgnore
	public Compte getCompte() {
		return compte;
	}
	@Setter
	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public Date getDateDoperation() {
		return dateDoperation;
	}
	public void setDateDoperation(Date dateDoperation) {
		this.dateDoperation = dateDoperation;
	}
	public Operation() {
	}
	public Operation(double montant, Date dateDoperation) {
		super();
		this.montant = montant;
		this.dateDoperation = dateDoperation;
	}
	
	
}
