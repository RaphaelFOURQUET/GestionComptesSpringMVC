package com.adaming.gestiondescomptes;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.adaming.gestiondescomptes.entitis.Compte;
import com.adaming.gestiondescomptes.entitis.CompteCourant;
import com.adaming.gestiondescomptes.entitis.CompteEpargne;
import com.adaming.gestiondescomptes.exceptions.RechercheCompteException;
import com.adaming.gestiondescomptes.service.client.IclientService;
import com.adaming.gestiondescomptes.service.compte.IcompteService;

public class CompteServiceTest {

	private static ClassPathXmlApplicationContext context;
	private static IcompteService service;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("app.xml");
		service = (IcompteService) context.getBean("serviceCompte");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}
	/*
	@Test
	public void testAddCompte() {
		Compte cp = new CompteCourant(0, new Date(), -500);
		Compte cp1 = new CompteCourant(5000, new Date(), 0);
		Compte cp2 = new CompteCourant(2500, new Date(), 0);
		Compte cp3 = new CompteEpargne(1000, new Date(),2);
		Compte cp4 = new CompteEpargne(15000, new Date(), 4);
		service.addCompte(cp, 3L, 1L);
		service.addCompte(cp1, 4L, 1L);
		service.addCompte(cp2, 5L, 2L);
		service.addCompte(cp3, 6L, 3L);
		service.addCompte(cp4, 6L, 3L);
		assertNotNull(cp.getNumeroCompte());
		assertNotNull(cp1.getNumeroCompte());
		assertNotNull(cp2.getNumeroCompte());
		assertNotNull(cp3.getNumeroCompte());
		assertNotNull(cp4.getNumeroCompte());
	}

	@Test
	public void testDeleteCompte() {
		Compte c =service.deleteCompte(1L);
	}

	

	@Test
	public void testUpdateCompte() {
		Compte c = service.getCompte(1L);
		c.setSoldeCompte(-300);
		service.updateCompte(c);
		Compte c2 = service.getCompte(1L);
		assertNotSame(c.getSoldeCompte(),c2.getSoldeCompte());
	}
     @Test
	 public void testGetCompte() {
		Compte c = service.getCompte(1L);
		assertNotNull(c.getNumeroCompte());
	}
	@Test
	public void testGetComptesByClient() {
		List<Compte> tabC =  service.getComptesByClient(4L);
		assertNotNull(tabC.size()>0);
	}

	@Test
	public void testGetCompteByEmploye() {
		List<Compte> tabC =  service.getCompteByEmploye(1L);
		assertNotNull(tabC.size()>0);
	}
  
	@Test
	public void testGetComptesByClient() {
		List<Compte> tabC =  service.getComptesByClient(4L);
		assertNotNull(tabC.size()>0);
	}
	*/
	
}
