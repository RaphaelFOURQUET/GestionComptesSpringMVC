package com.adaming.gestiondescomptes.dao.employe;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.adaming.gestiondescomptes.entitis.Employe;
import com.adaming.gestiondescomptes.entitis.Groupe;

public class EmployeDaoImpl implements IemployeDao {
   
	Logger log = Logger.getLogger("EmployeDaoImpl");
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Employe addEmploye(Employe e) {
		em.persist(e);
		log.info("l'employe "+e.getCodeEmploye()+": e bien �t� ajout�");
		return e;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Employe> employes() {
		Query query = em.createQuery("from Employe");
		log.info(" le nombre d'employes est: "+query.getResultList().size());
		return query.getResultList();
	}

	@Override
	public void addEmployerToGroupe(Long idGroupe, Long idEmploye) {
		Groupe  g = em.find(Groupe.class,idGroupe);
		Employe e = em.find(Employe.class,idEmploye);
		g.getEmployes().add(e);
		e.getGroupes().add(g);
		log.info("l'employe "+e.getCodeEmploye()+" a bien �t� ajout� au grupe N�"+g.getNomGroupe());
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Employe> getEmployesGroupe(Long idGroupe) {
		Query query = em.createQuery("from Employe e inner join e.groupes eg where eg.idGroupe=:x");
		query.setParameter("x",idGroupe);
		log.info(" le nombre d'employes est: "+query.getResultList().size()+"du groupe: "+idGroupe);
		return query.getResultList();
	}

}
