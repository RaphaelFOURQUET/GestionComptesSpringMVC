package com.adaming.gestiondescomptes.service.employe;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.transaction.annotation.Transactional;

import com.adaming.gestiondescomptes.dao.employe.IemployeDao;
import com.adaming.gestiondescomptes.entitis.Employe;
@Transactional
public class EmployeServiceImpl implements IemployeService {
	Logger log = Logger.getLogger("EmployeServiceImpl");

	private IemployeDao dao;

	public void setDao(IemployeDao dao) {
		this.dao = dao;
		log.info("<-------Dao Employe Injected------>");
	}

	@Override
	public Employe addEmploye(Employe e) {
		return dao.addEmploye(e);
	}

	@Override
	public List<Employe> employes() {
		return dao.employes();
	}

	@Override
	public void addEmployerToGroupe(Long idGroupe, Long idEmploye) {
		dao.addEmployerToGroupe(idGroupe, idEmploye);
	}

	@Override
	public List<Employe> getEmployesGroupe(Long idGroupe) {
		return dao.getEmployesGroupe(idGroupe);
	}

}
