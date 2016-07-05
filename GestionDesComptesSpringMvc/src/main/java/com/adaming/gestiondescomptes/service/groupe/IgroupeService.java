package com.adaming.gestiondescomptes.service.groupe;

import java.util.List;

import com.adaming.gestiondescomptes.entitis.Groupe;

public interface IgroupeService {


	public Groupe addGroupe(Groupe g);

	public List<Groupe> getGroupes();
}
