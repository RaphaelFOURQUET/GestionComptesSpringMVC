package com.adaming.gestiondescomptes.entitis;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("CC")
public class CompteCourant extends Compte {

	private double decouvert;

	public double getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}

	public CompteCourant(double soldeCompte, Date dateDeCreation,
			double decouvert) {
		super(soldeCompte, dateDeCreation);
		this.decouvert = decouvert;
	}

	public CompteCourant(double decouvert) {
		super();
		this.decouvert = decouvert;
	}
	public CompteCourant() {
	}
	
    
	
}
