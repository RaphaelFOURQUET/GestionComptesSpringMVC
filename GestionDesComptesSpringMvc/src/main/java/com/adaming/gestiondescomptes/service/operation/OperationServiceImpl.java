package com.adaming.gestiondescomptes.service.operation;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.adaming.gestiondescomptes.dao.compte.IcompteDao;
import com.adaming.gestiondescomptes.dao.operation.IoperationDao;
import com.adaming.gestiondescomptes.entitis.Compte;
import com.adaming.gestiondescomptes.entitis.Operation;
import com.adaming.gestiondescomptes.entitis.Retrait;
import com.adaming.gestiondescomptes.entitis.Verssement;
import com.adaming.gestiondescomptes.exceptions.RechercheCompteException;
import com.adaming.gestiondescomptes.exceptions.RetraitException;

@Transactional
public class OperationServiceImpl implements IoperationService {

	Logger log = Logger.getLogger("OperationServiceImpl");

	private IoperationDao dao;
    
	@Autowired
	private IcompteDao daoCompte;
	
	public void setDao(IoperationDao dao) {
		this.dao = dao;
		log.info("<-------dao Operation injected------>");
	}

	@Override
	public void verser(Long idCompte, double montant, Long idEmploye) throws RechercheCompteException {
		dao.addOeration(new Verssement(montant, new Date()), idCompte, idEmploye);
        Compte cp = daoCompte.getCompte(idCompte);
        log.info("l'aincien solde est : "+" "+cp.getSoldeCompte());
        cp.setSoldeCompte(cp.getSoldeCompte()+montant);
        log.info("apres le verssement le  solde est : "+" "+cp.getSoldeCompte());
	}

	@Override
	public void retirer(Long idCompte, double montant, Long idEmploye) throws RetraitException, RechercheCompteException {
		dao.addOeration(new Retrait(montant, new Date()), idCompte, idEmploye);
		Compte cp = daoCompte.getCompte(idCompte);
		log.info("l'aincien solde est : "+" "+cp.getSoldeCompte());
		if(cp.getSoldeCompte() <=0 || montant>cp.getSoldeCompte()){
			throw new RetraitException(" le solde est insufisant pour cette op�ration");
		}
		cp.setSoldeCompte(cp.getSoldeCompte()-montant);
		log.info("apres le retarait le  solde est : "+" "+cp.getSoldeCompte());

	}

	@Override
	public void virement(Long idCompte1, Long idCompte2, double montant,
			Long idEmploye) throws RetraitException, RechercheCompteException{
		
		retirer(idCompte1, montant, idEmploye);
		verser(idCompte2, montant, idEmploye);
	}

	@Override
	public List<Operation> getOperationsByCompte(Long idCompte) {
		return dao.getOperationsByCompte(idCompte);
	}

}
