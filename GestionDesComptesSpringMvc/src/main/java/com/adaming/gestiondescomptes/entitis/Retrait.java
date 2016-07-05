package com.adaming.gestiondescomptes.entitis;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("Retrait")
public class Retrait extends Operation{

	public Retrait() {
		super();
	}

	public Retrait(double montant, Date dateDoperation) {
		super(montant, dateDoperation);
	}

}
