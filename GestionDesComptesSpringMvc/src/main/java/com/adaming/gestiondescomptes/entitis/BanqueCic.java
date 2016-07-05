package com.adaming.gestiondescomptes.entitis;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CIC")
public class BanqueCic extends Banque {

	public BanqueCic() {
		super();
	}

	public BanqueCic(String nomAgence, String adrrAgence, String codePostale) {
		super(nomAgence, adrrAgence, codePostale);
	}

}
