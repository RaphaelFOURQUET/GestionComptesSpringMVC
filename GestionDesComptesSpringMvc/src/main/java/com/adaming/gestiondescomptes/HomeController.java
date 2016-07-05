package com.adaming.gestiondescomptes;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.adaming.gestiondescomptes.entitis.Client;
import com.adaming.gestiondescomptes.entitis.Employe;
import com.adaming.gestiondescomptes.service.client.IclientService;
import com.adaming.gestiondescomptes.service.employe.IemployeService;
import com.fasterxml.jackson.annotation.JsonFormat.Value;

@Controller
public class HomeController {
	
	
	
	@Autowired
	private IclientService serviceClient;
	
	@RequestMapping(value="/",method = RequestMethod.GET)
	public String homePage(Model model){
		model.addAttribute("modelc",new Client());
		//model.addAttribute("modelEmploye",new Employe());
		return "home";
	}
	
	@RequestMapping(value="/addClient")
	public String addClient(@ModelAttribute("modelc") @Valid Client c
			                ,BindingResult result){
		if(result.hasErrors()){
			return "home";
		}
		serviceClient.addClient(c);
		
		return "home";
	}
	

	
	

	

}
