package com.adaming.gestiondescomptes;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.adaming.gestiondescomptes.entitis.Client;
import com.adaming.gestiondescomptes.entitis.Employe;
import com.adaming.gestiondescomptes.service.employe.IemployeService;

@Controller
public class EmployeController {
    
	@Autowired
	private IemployeService serviceEmploye;
	
	@RequestMapping(value="/Employe",method = RequestMethod.GET)
	public String homePage(Model model){
		model.addAttribute("modelEmploye",new Employe());
		return "Employe";
	}
	
	@RequestMapping(value = "/addEmploye")
	public String addEmploye(@ModelAttribute ("modelEmploye")
	                         @Valid Employe e
			                 ,BindingResult resultat){
		if(resultat.hasErrors()){
			return "Employe";
		}
		serviceEmploye.addEmploye(e);
		return "Employe";
	}
}
