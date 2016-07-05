package com.adaming.gestiondescomptes.entitis;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("Verssement")
public class Verssement extends Operation{

	public Verssement() {
		super();
	}

	public Verssement(double montant, Date dateDoperation) {
		super(montant, dateDoperation);
	}

}
