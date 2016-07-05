package com.adaming.gestiondescomptes.dao.compte;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.adaming.gestiondescomptes.entitis.Client;
import com.adaming.gestiondescomptes.entitis.Compte;
import com.adaming.gestiondescomptes.entitis.Employe;
import com.adaming.gestiondescomptes.exceptions.RechercheCompteException;

public class CompteDaoImpl implements IcompteDao {

	Logger log = Logger.getLogger("CompteDaoImpl");

	@PersistenceContext
	private EntityManager em;

	@Override
	public Compte addCompte(Compte cp, Long idClient, Long idEmplye) {
		Client c = em.find(Client.class, idClient);
		Employe e = em.find(Employe.class, idEmplye);
		cp.setClient(c);
		cp.setEmploye(e);
		em.persist(cp);
		log.info("le compte :" + cp.getNumeroCompte() + "de : "
				+ c.getNomClient() + " a bien été crié avec l'employe: "
				+ e.getNomEmploye());
		return cp;
	}

	@Override
	public Compte deleteCompte(Long idCompte) {
		Compte cp = em.find(Compte.class, idCompte);
		em.remove(cp);
		log.info("le compte : " + cp.getNumeroCompte() + "a bien été supprimé");
		return cp;
	}

	@Override
	public Compte getCompte(Long idCompte) throws RechercheCompteException {
		Compte cp = em.find(Compte.class, idCompte);

		if (cp == null) {
			throw new RechercheCompteException("le compte est introuvable !!");
		}
		
		log.info("le compte " + cp.getNumeroCompte() + " a bien été recuérer");
		return cp;

	}

	@Override
	public Compte updateCompte(Compte cp) {
		em.merge(cp);
		log.info("le compte " + cp.getNumeroCompte() + " a bien été modifié");
		return cp;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Compte> getComptesByClient(Long idClient) {
		Query query = em
				.createQuery("from Compte cp where cp.client.idClient=:x");
		query.setParameter("x", idClient);
		log.info("le nombre de compte du client avec l'ID : " + idClient
				+ "est : " + query.getResultList().size());
		return query.getResultList();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Compte> getCompteByEmploye(Long idEmploye) {
		Query query = em
				.createQuery("from Compte cp where cp.employe.codeEmploye=:x");
		query.setParameter("x", idEmploye);
		log.info("le nombre de compte crieer par l'employe: " + idEmploye
				+ " est : " + query.getResultList().size());
		return query.getResultList();
	}

}
