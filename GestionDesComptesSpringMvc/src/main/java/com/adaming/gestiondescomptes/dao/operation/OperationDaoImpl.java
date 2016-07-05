package com.adaming.gestiondescomptes.dao.operation;

import java.util.List;



import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.adaming.gestiondescomptes.entitis.Compte;
import com.adaming.gestiondescomptes.entitis.Employe;
import com.adaming.gestiondescomptes.entitis.Operation;

public class OperationDaoImpl implements IoperationDao{
    
	Logger log = Logger.getLogger("OperationDaoImpl");
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Operation addOeration(Operation o, Long idCompte, Long idEmploye) {
		Compte  c  = em.find(Compte.class, idCompte);
		Employe e = em.find(Employe.class, idEmploye);
		o.setCompte(c);
		o.setEmploye(e);
		em.persist(o);
		log.info("l'opertaion "+o.getIdOperation()+"a bien été efféctues");
		return o;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Operation> getOperationsByCompte(Long idCompte) {
		Query query = em.createQuery("from Operation o where o.compte.numeroCompte=:x");
		query.setParameter("x",idCompte);
		log.info("le nombre d'operation effectué sur le compte"+idCompte+"est :"+query.getResultList().size());
		return query.getResultList();
	}

}
