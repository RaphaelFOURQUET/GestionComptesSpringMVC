package com.adaming.gestiondescomptes.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adaming.gestiondescomptes.entitis.Banque;
import com.adaming.gestiondescomptes.entitis.Compte;
import com.adaming.gestiondescomptes.service.banque.IbanqueService;

@RestController
public class BanqueRest {
	
	@Autowired
	private IbanqueService service;
	
	@RequestMapping(value="/banque", method=RequestMethod.POST)
	public Banque addBanque(@RequestBody Banque bq) {
		return service.addBanque(bq);
	}
	
	@RequestMapping(value="/banque/comptes/{idBanque}", method=RequestMethod.GET)
	public List<Compte> getListComptes(@PathVariable Long idBanque) {
		return service.getListComptes(idBanque);
	}
	
	@RequestMapping(value="/banque/addToCompte/{idCompte}/{idBanque}", method=RequestMethod.PUT)
	public void addBanqueToCompte(@PathVariable Long idCompte, @PathVariable Long idBanque) {
		service.addBanqueToCompte(idCompte, idBanque);
	}
	

}
