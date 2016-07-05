package com.adaming.gestiondescomptes;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.adaming.gestiondescomptes.entitis.Groupe;
import com.adaming.gestiondescomptes.service.groupe.IgroupeService;

public class GroupeServiceTest {
    private static ClassPathXmlApplicationContext context;
    private static IgroupeService service;
	
    @BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("app.xml");
		service = (IgroupeService)context.getBean("groupeService");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}

	@Test
	public void testAddGroupe() {
		Groupe g = new Groupe("Groupe 01");
		Groupe g1 = new Groupe("Groupe 02");
		Groupe g2 = new Groupe("Groupe 03");
		Groupe g3 = new Groupe("Groupe 04");
		service.addGroupe(g);
		service.addGroupe(g2);
		service.addGroupe(g1);
		service.addGroupe(g3);
		assertNotNull(g.getIdGroupe());
		assertNotNull(g1.getIdGroupe());
		assertNotNull(g2.getIdGroupe());
		assertNotNull(g3.getIdGroupe());
	}
    /*
	@Test
	public void testGetGroupes() {
		List<Groupe> tabG =service.getGroupes();
		assertTrue(tabG.size()>0);
	}
	*/

}
