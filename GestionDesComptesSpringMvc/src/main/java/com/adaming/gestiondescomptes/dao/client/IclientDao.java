package com.adaming.gestiondescomptes.dao.client;

import java.util.List;

import com.adaming.gestiondescomptes.entitis.Client;

public interface IclientDao {

	public Client addClient(Client c);

	public Client suprimmerClient(Long idClient);

	public Client updateClient(Client c);

	public Client getClient(Long idClient);

	public List<Client> getClients();

	public List<Client> getClientByMc(String mc);

}
