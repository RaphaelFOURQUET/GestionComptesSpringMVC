package com.adaming.gestiondescomptes.dao.groupe;

import java.util.List;

import com.adaming.gestiondescomptes.entitis.Groupe;

public interface IgroupeDao {

	public Groupe addGroupe(Groupe g);

	public List<Groupe> getGroupes();
}
