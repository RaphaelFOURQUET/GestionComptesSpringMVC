package com.adaming.gestiondescomptes.dao.banque;

import java.util.List;

import com.adaming.gestiondescomptes.entitis.Banque;
import com.adaming.gestiondescomptes.entitis.Compte;

public interface IbanqueDao {

	public Banque addBanque(Banque bq);

	public List<Compte> getListComptes(Long idBanque);

	public void addBanqueToCompte(Long idCompte, Long idBanque);

}
