package com.adaming.gestiondescomptes.service.operation;

import java.util.List;

import com.adaming.gestiondescomptes.entitis.Operation;
import com.adaming.gestiondescomptes.exceptions.RechercheCompteException;
import com.adaming.gestiondescomptes.exceptions.RetraitException;

public interface IoperationService {
	
	public void verser      (Long idCompte, double montant,Long idEmploye) throws RechercheCompteException,RechercheCompteException;
	
	public void retirer     (Long idCompte,double montant,Long idEmploye) throws RetraitException,RechercheCompteException;
	
	public void virement    (Long idCompte1,Long idCompte2,double montant,Long idEmploye) throws RetraitException, RechercheCompteException;

	public List<Operation>  getOperationsByCompte(Long idCompte);

}
