package com.adaming.gestiondescomptes.dao.groupe;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.adaming.gestiondescomptes.entitis.Groupe;

public class GroupeDaoImpl implements IgroupeDao{
    
	Logger log = Logger.getLogger("GroupeDaoImpl");
    
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Groupe addGroupe(Groupe g) {
		em.persist(g);
		log.info("le groupe "+g.getIdGroupe()+" a bien été enregistrée");
		return g;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Groupe> getGroupes() {
		Query query = em.createQuery("from Groupe g");
		log.info("le nombre de groupe est : "+query.getResultList().size());
		return query.getResultList();
	}

}
