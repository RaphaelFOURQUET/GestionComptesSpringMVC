package com.adaming.gestiondescomptes;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.adaming.gestiondescomptes.entitis.Employe;
import com.adaming.gestiondescomptes.entitis.Groupe;
import com.adaming.gestiondescomptes.service.client.IclientService;
import com.adaming.gestiondescomptes.service.employe.IemployeService;
import com.adaming.gestiondescomptes.service.groupe.IgroupeService;

public class EmployeServiceTestU {

	private static ClassPathXmlApplicationContext context;
	private static IemployeService service;
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("app.xml");
		service = (IemployeService) context.getBean("serviceEmploye");
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}

	
	
    /*
     * @Test
	public void testAddEmployerToGroupe() {
		service.addEmployerToGroupe(1L, 1L);
		service.addEmployerToGroupe(1L, 2L);
		service.addEmployerToGroupe(3L, 1L);
		service.addEmployerToGroupe(4L, 3L);
	
		assertTrue(true);
	}
      @Test
	public void testAddEmploye() {
		Employe e = new Employe("Boumaza ADEL");
		Employe e1 = new Employe("Boumaza RAFIK");
		Employe e2 = new Employe("Boumaza REDA");
		service.addEmploye(e);
		service.addEmploye(e1);
		service.addEmploye(e2);
		assertNotNull(e.getCodeEmploye());
		assertNotNull(e1.getCodeEmploye());
		assertNotNull(e2.getCodeEmploye());
	}
	@Test
	public void testEmployes() {
		List<Employe> tabE = service.employes();
		assertTrue(tabE.size()>0);
	}

    @Test
	public void testAddEmployerToGroupe() {
		service.addEmployerToGroupe(1L, 1L);
		assertTrue(true);
	}

	
	@Test
	public void testGetEmployesGroupe() {
		List<Employe> tabE = service.getEmployesGroupe(1L);
		assertTrue(tabE.size()>0);
	}
   */
	@Test
	public void testGetEmployesGroupe() {
		List<Employe> tabE = service.getEmployesGroupe(1L);
		List<Employe> tabE1 = service.getEmployesGroupe(2L);
		List<Employe> tabE2 = service.getEmployesGroupe(3L);
		List<Employe> tabE3 = service.getEmployesGroupe(4L);
		assertTrue(tabE.size()>0);
	}
}
