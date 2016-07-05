package com.adaming.gestiondescomptes.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adaming.gestiondescomptes.entitis.Client;
import com.adaming.gestiondescomptes.service.client.IclientService;

@RestController
public class ClientRest {
	
	@Autowired
	private IclientService service;
	
	@RequestMapping(value="/clients",method=RequestMethod.GET)
	public List<Client> getClients() {
		return service.getClients();
	}
	
	@RequestMapping(value="/client/{idClient}",method=RequestMethod.GET)
	public Client getClient(@PathVariable Long idClient) {
		return service.getClient(idClient);
	}
	
	@RequestMapping(value="/client", method=RequestMethod.POST)
	public Client addClient(@RequestBody Client c){
		return service.addClient(c);
	}
	
	@RequestMapping(value="/client/{idClient}", method=RequestMethod.DELETE)
	public Client deleteClient(@PathVariable Long idClient){
		return service.suprimmerClient(idClient);
	}

	@RequestMapping(value="/client/{idClient}", method=RequestMethod.PUT)
	public Client updateClient(@PathVariable Long idClient,@RequestBody Client c){
		c.setIdClient(idClient);
		return service.updateClient(c);
	}
	
	@RequestMapping(value="/client/byMc/{mc}", method=RequestMethod.GET)
	public List<Client> getClientByMc(@PathVariable String mc){
		return service.getClientByMc(mc);
	}

}
