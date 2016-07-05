package com.adaming.gestiondescomptes.entitis;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("CE")
public class CompteEpargne extends Compte {

	private double tauxInteret;

	public double getTauxInteret() {
		return tauxInteret;
	}

	public void setTauxInteret(double tauxInteret) {
		this.tauxInteret = tauxInteret;
	}
	public CompteEpargne() {
	}

	public CompteEpargne(double soldeCompte, Date dateDeCreation,
			double tauxInteret) {
		super(soldeCompte, dateDeCreation);
		this.tauxInteret = tauxInteret;
	}

	public CompteEpargne(double tauxInteret) {
		super();
		this.tauxInteret = tauxInteret;
	}
	
	
}
