package com.adaming.gestiondescomptes.dao.operation;

import java.util.List;

import com.adaming.gestiondescomptes.entitis.Operation;

public interface IoperationDao {

	public Operation addOeration(Operation o,Long idCompte,Long idEmploye);
	
	public List<Operation> getOperationsByCompte(Long idCompte);
	
	
	
}
