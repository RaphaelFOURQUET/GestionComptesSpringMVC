package com.adaming.gestiondescomptes.service.banque;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.transaction.annotation.Transactional;

import com.adaming.gestiondescomptes.dao.banque.IbanqueDao;
import com.adaming.gestiondescomptes.entitis.Banque;
import com.adaming.gestiondescomptes.entitis.Compte;
@Transactional
public class BanqueServiceImpl implements IbanqueService{
    Logger log = Logger.getLogger("BanqueServiceImpl");
	
    private IbanqueDao dao;
	
    
	public void setDao(IbanqueDao dao) {
		this.dao = dao;
		log.info("<---dao Banque injected------>");
	}
	

	@Override
	public Banque addBanque(Banque bq) {
		return dao.addBanque(bq);
	}

	@Override
	public List<Compte> getListComptes(Long idBanque) {
		return dao.getListComptes(idBanque);
	}

	@Override
	public void addBanqueToCompte(Long idCompte, Long idBanque) {
		dao.addBanqueToCompte(idCompte, idBanque);
		
	}

}
