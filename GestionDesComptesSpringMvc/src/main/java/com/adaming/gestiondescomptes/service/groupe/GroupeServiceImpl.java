package com.adaming.gestiondescomptes.service.groupe;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.transaction.annotation.Transactional;


import com.adaming.gestiondescomptes.dao.groupe.IgroupeDao;
import com.adaming.gestiondescomptes.entitis.Groupe;
@Transactional
public class GroupeServiceImpl implements IgroupeService{
    
	Logger log = Logger.getLogger("GroupeServiceImpl");
	
	private IgroupeDao dao;
	
    public void setDao(IgroupeDao dao) {
		this.dao = dao;
		log.info("<-------Dao Groupe Injected------>");
	}

	@Override
	public Groupe addGroupe(Groupe g) {
		return dao.addGroupe(g);
	}

	@Override
	public List<Groupe> getGroupes() {
		return dao.getGroupes();
	}

}
