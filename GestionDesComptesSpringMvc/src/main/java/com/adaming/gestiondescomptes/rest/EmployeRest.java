package com.adaming.gestiondescomptes.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adaming.gestiondescomptes.entitis.Employe;
import com.adaming.gestiondescomptes.service.employe.IemployeService;

@RestController
public class EmployeRest {
	
	@Autowired
	private IemployeService service;
	
	@RequestMapping(value="/employe", method=RequestMethod.POST)
	public Employe addEmploye(@RequestBody Employe e){
		return service.addEmploye(e);
	}
	
	@RequestMapping(value="/employes",method=RequestMethod.GET)
	public List<Employe> getEmployes() {
		return service.employes();
	}
	
	@RequestMapping(value="/employe/addToGroupe/{idGroupe}/{idEmploye}",method=RequestMethod.PUT)
	public void addEmployeToGroupe(@PathVariable Long idGroupe,@PathVariable Long idEmploye) {
		service.addEmployerToGroupe(idGroupe, idEmploye);
	}
	
	@RequestMapping(value="/employe/getEmployesGroupe/{idGroupe}",method=RequestMethod.GET)
	public List<Employe> getEmployesGroupe(@PathVariable Long idGroupe) {
		return service.getEmployesGroupe(idGroupe);
	}

}
