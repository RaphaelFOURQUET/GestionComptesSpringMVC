package com.adaming.gestiondescomptes.dao.banque;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.adaming.gestiondescomptes.entitis.Banque;
import com.adaming.gestiondescomptes.entitis.Compte;

public class BanqueDaoImpl implements IbanqueDao {
    
	Logger log = Logger.getLogger("BanqueDaoImpl");
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Banque addBanque(Banque bq) {
		em.persist(bq);
		log.info("la banque "+bq.getIdBanque()+"a bien été criée");
		return bq;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Compte> getListComptes(Long idBanque) {
		Query query = em.createQuery("from Compte c inner join c.banques cb where cb.idBanque=:x");
		query.setParameter("x", idBanque);
		log.info("le nombre de compte trouvés est "+query.getResultList().size()+"dans la banque : "+idBanque);
		return query.getResultList();
	}

	@Override
	public void addBanqueToCompte(Long idCompte, Long idBanque) {
		Compte cp = em.find(Compte.class,idCompte);
		Banque bq = em.find(Banque.class,idBanque);
		cp.getBanques().add(bq);
		bq.getTabComptes().add(cp);
		
	}

}
