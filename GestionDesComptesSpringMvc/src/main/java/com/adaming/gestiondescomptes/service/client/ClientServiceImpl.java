package com.adaming.gestiondescomptes.service.client;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.transaction.annotation.Transactional;

import com.adaming.gestiondescomptes.dao.client.IclientDao;
import com.adaming.gestiondescomptes.entitis.Client;
@Transactional
public class ClientServiceImpl implements IclientService {
    
	Logger log = Logger.getLogger("ClientServiceImpl");
	
	private IclientDao dao;

	public void setDao(IclientDao dao) {
		this.dao = dao;
		log.info("<-------Dao Client Injected--------->");
	}

	@Override
	public Client addClient(Client c) {
		return dao.addClient(c);
	}

	@Override
	public Client suprimmerClient(Long idClient) {
		return dao.suprimmerClient(idClient);
	}

	@Override
	public Client updateClient(Client c) {
		return dao.updateClient(c);
	}

	@Override
	public Client getClient(Long idClient) {
		return dao.getClient(idClient);
	}

	@Override
	public List<Client> getClients() {
		return dao.getClients();
	}

	@Override
	public List<Client> getClientByMc(String mc) {
		return dao.getClientByMc(mc);
	}

}
