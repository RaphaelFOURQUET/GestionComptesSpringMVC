package com.adaming.gestiondescomptes.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adaming.gestiondescomptes.entitis.Compte;
import com.adaming.gestiondescomptes.exceptions.RechercheCompteException;
import com.adaming.gestiondescomptes.service.compte.IcompteService;

@RestController
public class CompteRest {
	
	@Autowired
	private IcompteService service;
	
	@RequestMapping(value="/compte/{idClient}/{idEmploye}", method=RequestMethod.POST)
	public Compte addCompte(@RequestBody Compte cp,@PathVariable Long idClient,@PathVariable Long idEmploye) {
		return service.addCompte(cp, idClient, idEmploye);
	}
	
	@RequestMapping(value="/compte/{idCompte}", method=RequestMethod.DELETE)
	public Compte deleteCompte(@PathVariable Long idCompte) {
		return service.deleteCompte(idCompte);
	}
	
	@RequestMapping(value="/compte/{idCompte}", method=RequestMethod.GET)
	public Compte getCompte(@PathVariable Long idCompte) throws RechercheCompteException {
		return service.getCompte(idCompte);
	}
	
	@RequestMapping(value="/compte/{idCompte}", method=RequestMethod.PUT)
	public Compte updateCompte(@RequestBody Compte cp,@PathVariable Long idCompte) {
		cp.setNumeroCompte(idCompte);
		return service.updateCompte(cp);
	}
	
	@RequestMapping(value="/compte/byClient/{idClient}", method=RequestMethod.GET)
	public List<Compte> getComptesByClient(@PathVariable Long idClient) {
		return service.getComptesByClient(idClient);
	}
	
	@RequestMapping(value="/compte/byEmploye/{idEmploye}", method=RequestMethod.GET)
	public List<Compte> getCompteByEmploye(@PathVariable Long idEmploye) {
		return service.getCompteByEmploye(idEmploye);
	}

}
