package com.adaming.gestiondescomptes.service.employe;

import java.util.List;

import com.adaming.gestiondescomptes.entitis.Employe;

public interface IemployeService {

	public Employe addEmploye(Employe e);

	public List<Employe> employes();
	
	public void addEmployerToGroupe(Long idGroupe,Long idEmploye);
	
	public List<Employe> getEmployesGroupe(Long idGroupe);
}
