package com.adaming.gestiondescomptes.dao.employe;

import java.util.List;

import com.adaming.gestiondescomptes.entitis.Employe;

public interface IemployeDao {

	public Employe addEmploye(Employe e);

	public List<Employe> employes();
	
	public void addEmployerToGroupe(Long idGroupe,Long idEmploye);
	
	public List<Employe> getEmployesGroupe(Long idGroupe);
}
