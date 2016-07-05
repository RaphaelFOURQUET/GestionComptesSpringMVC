package com.adaming.gestiondescomptes.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adaming.gestiondescomptes.entitis.Groupe;
import com.adaming.gestiondescomptes.service.groupe.IgroupeService;

@RestController
public class GroupeRest {
	
	@Autowired
	private IgroupeService service;
	
	@RequestMapping(value="/groupe", method=RequestMethod.POST)
	public Groupe addGroupe(@RequestBody Groupe g) {
		return service.addGroupe(g);
	}

	@RequestMapping(value="/groupes", method=RequestMethod.GET)
	public List<Groupe> getGroupes() {
		return service.getGroupes();
	}

}
