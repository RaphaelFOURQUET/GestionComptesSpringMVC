package com.adaming.gestiondescomptes.service.compte;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.transaction.annotation.Transactional;

import com.adaming.gestiondescomptes.dao.compte.IcompteDao;
import com.adaming.gestiondescomptes.entitis.Compte;
import com.adaming.gestiondescomptes.exceptions.RechercheCompteException;

@Transactional
public class CompteServiceImpl implements IcompteService {
    
	Logger log = Logger.getLogger("CompteServiceImpl");
	
    private IcompteDao dao;
	
	public void setDao(IcompteDao dao) {
		this.dao = dao;
		log.info("<-------Dao Compte Injected ------->");
	}

	@Override
	public Compte addCompte(Compte cp, Long idClient, Long idEmplye) {
		return dao.addCompte(cp, idClient, idEmplye);
	}

	@Override
	public Compte deleteCompte(Long idCompte) {
		return dao.deleteCompte(idCompte);
	}

	@Override
	public Compte getCompte(Long idCompte) throws RechercheCompteException {
		return dao.getCompte(idCompte);
	}

	@Override
	public Compte updateCompte(Compte cp) {
		return dao.updateCompte(cp);
	}

	@Override
	public List<Compte> getComptesByClient(Long idClient) {
		return dao.getComptesByClient(idClient);
	}

	@Override
	public List<Compte> getCompteByEmploye(Long idEmploye) {
		return dao.getCompteByEmploye(idEmploye);
	}

}
