package com.adaming.gestiondescomptes.entitis;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("BNP")
public class BanqueBnp extends Banque {

	public BanqueBnp() {
		super();
	}

	public BanqueBnp(String nomAgence, String adrrAgence, String codePostale) {
		super(nomAgence, adrrAgence, codePostale);
	}

}
