package com.adaming.gestiondescomptes;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.adaming.gestiondescomptes.dao.compte.IcompteDao;
import com.adaming.gestiondescomptes.entitis.Compte;
import com.adaming.gestiondescomptes.entitis.Operation;
import com.adaming.gestiondescomptes.exceptions.RetraitException;
import com.adaming.gestiondescomptes.service.compte.IcompteService;
import com.adaming.gestiondescomptes.service.operation.IoperationService;

public class OperationServiceTestU {

	private static ClassPathXmlApplicationContext context;
	private static IoperationService service;
	private static IcompteService serviceCompte;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
    context =  new ClassPathXmlApplicationContext("app.xml");
    service = (IoperationService) context.getBean("serviceOperation");
    serviceCompte = (IcompteService) context.getBean("serviceCompte");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}
	
	/*
	@Test
	public void testVerser() {
		Compte c = serviceCompte.getCompte(1L);
		double ancienSolde = c.getSoldeCompte();
		service.verser(1L, 1200, 1L);
		Compte c2 = serviceCompte.getCompte(1L);
		double apresSolde = c2.getSoldeCompte();
		assertNotSame(ancienSolde, apresSolde);
	}

	@Test
	public void testRetirer() {
		Compte c = serviceCompte.getCompte(2L);
		double ancienSolde = c.getSoldeCompte();
		service.retirer(2L, 400, 1L);
		Compte c2 = serviceCompte.getCompte(2L);
		double apresSolde = c2.getSoldeCompte();
		assertNotSame(ancienSolde, apresSolde);
	}

	@Test
	public void testVirement() {
		Compte c = serviceCompte.getCompte(4L);
		double ancienSolde = c.getSoldeCompte();
		service.virement(4L, 5L, 500, 1L);
		Compte c2 = serviceCompte.getCompte(4L);
		double apresSolde = c2.getSoldeCompte();
		assertNotSame(ancienSolde, apresSolde);
	}

	@Test
	public void testGetOperationsByCompte() {
		List<Operation> tabO = service.getOperationsByCompte(1L);
		assertTrue(tabO.size()>0);
	}
    
	*/
}
