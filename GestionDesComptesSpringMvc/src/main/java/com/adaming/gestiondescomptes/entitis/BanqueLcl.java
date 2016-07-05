package com.adaming.gestiondescomptes.entitis;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("LCL")
public class BanqueLcl extends Banque {

	public BanqueLcl() {
		super();
	}

	public BanqueLcl(String nomAgence, String adrrAgence, String codePostale) {
		super(nomAgence, adrrAgence, codePostale);
	}

}
