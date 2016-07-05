package com.adaming.gestiondescomptes.dao.client;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.adaming.gestiondescomptes.entitis.Client;

public class ClientDaoImpl implements IclientDao {
    Logger log = Logger.getLogger("ClientDaoImpl");
	
    @PersistenceContext
	private EntityManager em;
	
	@Override
	public Client addClient(Client c) {
		em.persist(c);
		log.info("le client: "+ c.getIdClient() +"<-->"+ "a bien été sauvegardé");
		return c;
	}

	@Override
	public Client suprimmerClient(Long idClient) {
		Client c = em.find(Client.class,idClient);
		em.remove(c);
		log.info("le client "+c.getIdClient() + ":"+"a bien été suprimmé");
		return c;
	}

	@Override
	public Client updateClient(Client c) {
		em.merge(c);
		log.info("le client "+":"+c.getIdClient() + ":" +"a bien été modifié");
		return c;
	}

	@Override
	public Client getClient(Long idClient) {
		Client c = em.find(Client.class,idClient);
		log.info(" le client "+c.getIdClient()+" :" +"a bien été récupéréer");
		return c;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Client> getClients() {
		Query query = em.createQuery("from Client c");
		log.info("le nombre de client :  "+query.getResultList().size());
		return query.getResultList();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Client> getClientByMc(String mc) {
		Query query = em.createQuery("from Client c where c.nomClient like :x");
		query.setParameter("x","%"+mc+"%");
		log.info("le nombre de clients qui son nom  commenece par "+mc+"est :"+query.getResultList().size());
		return query.getResultList();
	}

}
