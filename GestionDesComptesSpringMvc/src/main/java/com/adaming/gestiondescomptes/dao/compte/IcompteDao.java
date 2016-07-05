package com.adaming.gestiondescomptes.dao.compte;

import java.util.List;

import com.adaming.gestiondescomptes.entitis.Compte;
import com.adaming.gestiondescomptes.exceptions.RechercheCompteException;

public interface IcompteDao {

	public Compte addCompte(Compte cp,Long idClient,Long idEmplye);
	
	public Compte deleteCompte(Long idCompte);
	
	public Compte getCompte(Long idCompte) throws RechercheCompteException;
	
	public Compte updateCompte(Compte cp);
	
	public List<Compte> getComptesByClient(Long idClient);
	
	public List<Compte> getCompteByEmploye(Long idEmploye);
	
	
	
	
}
