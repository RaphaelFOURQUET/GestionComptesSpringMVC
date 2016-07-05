package com.adaming.gestiondescomptes;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.adaming.gestiondescomptes.entitis.Client;
import com.adaming.gestiondescomptes.service.client.IclientService;

public class ClientServiceTestU {

	private static ClassPathXmlApplicationContext context;
	private static IclientService service;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
    context =  new ClassPathXmlApplicationContext("app.xml");
    service = (IclientService) context.getBean("serviceClient");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}

	@Test
	public void testAddClient() {
		Client c = new Client("bounajama","sara",new Date(),"Avenu jean jaures");
		Client c2 = new Client("bourkab","hamza",new Date(),"Avenu jean jaures");
		Client c3 = new Client("saifi","rafik",new Date(),"Avenu jean jaures");
		service.addClient(c);
		service.addClient(c2);
		service.addClient(c3);
		assertNotNull(c.getIdClient());
		assertNotNull(c2.getIdClient());
		assertNotNull(c3.getIdClient());
		
	}

	/*@Test
	public void testSuprimmerClient() {
		List<Client> tabinitial = service.getClients();
		Client c =service.suprimmerClient(2L);
		List<Client> tabfinal = service.getClients();
		assertNotSame(tabfinal.size(), tabinitial.size());
		
	}

	@Test
	public void testUpdateClient() {
		Client c = service.getClient(3L);
		c.setNomClient("nomModifier");
		service.updateClient(c);
		Client c2 = service.getClient(3L);
		assertEquals(c2.getNomClient(), c.getNomClient());
		
	}

	@Test
	public void testGetClient() {
		Client c = service.getClient(3L);
		assertTrue(c.getIdClient() == 3L);
	}

	@Test
	public void testGetClients() {
		List<Client> tabC = service.getClients();
		assertTrue(tabC.size() > 0);
	}

	@Test
	public void testGetClientByMc() {
		List<Client> tabC = service.getClientByMc("a");
		for(Client c:tabC){
			assertNotNull(c.getNomClient().contains("a"));
		}
	}
	*/
	
}
