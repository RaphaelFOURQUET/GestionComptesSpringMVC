package com.adaming.gestiondescomptes.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adaming.gestiondescomptes.entitis.Operation;
import com.adaming.gestiondescomptes.exceptions.RechercheCompteException;
import com.adaming.gestiondescomptes.exceptions.RetraitException;
import com.adaming.gestiondescomptes.service.operation.IoperationService;

@RestController
public class OperationRest {
	
	@Autowired
	private IoperationService service;
	
	@RequestMapping(value="/operation/verser/{idCompte}/{idEmploye}/{montant}", method=RequestMethod.POST)
	public void verser(@PathVariable Long idCompte, @PathVariable double montant, @PathVariable Long idEmploye) throws RechercheCompteException,RechercheCompteException {
		service.verser(idCompte, montant, idEmploye);
	}
	
	@RequestMapping(value="/operation/retirer/{idCompte}/{idEmploye}/{montant}", method=RequestMethod.POST)
	public void retirer(@PathVariable Long idCompte, @PathVariable double montant, @PathVariable Long idEmploye) throws RetraitException,RechercheCompteException {
		service.retirer(idCompte, montant, idEmploye);
	}
	
	@RequestMapping(value="/operation/virer/{idCompte1}/{idCompte2}/{idEmploye}/{montant}", method=RequestMethod.POST)
	public void virement(@PathVariable Long idCompte1, @PathVariable Long idCompte2, @PathVariable double montant, @PathVariable Long idEmploye) throws RetraitException, RechercheCompteException {
		service.virement(idCompte1, idCompte2, montant, idEmploye);
	}

	@RequestMapping(value="/operation/byCompte/{idCompte}", method=RequestMethod.GET)
	public List<Operation> getOperationsByCompte(@PathVariable Long idCompte) {
		return service.getOperationsByCompte(idCompte);
	}

}
