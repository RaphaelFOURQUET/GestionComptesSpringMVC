package com.adaming.gestiondescomptes;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.adaming.gestiondescomptes.entitis.Banque;
import com.adaming.gestiondescomptes.entitis.BanqueBnp;
import com.adaming.gestiondescomptes.entitis.BanqueCic;
import com.adaming.gestiondescomptes.entitis.BanqueLcl;
import com.adaming.gestiondescomptes.entitis.Compte;
import com.adaming.gestiondescomptes.service.banque.IbanqueService;
import com.adaming.gestiondescomptes.service.client.IclientService;

public class BanqueServiceTest {

	private static ClassPathXmlApplicationContext context;
	private static IbanqueService service;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
    context =  new ClassPathXmlApplicationContext("app.xml");
    service = (IbanqueService) context.getBean("serviceBanque");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}
	/*@Test
	public void testAddBanque() {
		Banque cic = new BanqueCic("CicVictoire","avenu victoire","33000");
		Banque bnp = new BanqueBnp("BnpParis","avenu paris","75000");
		Banque lcl = new BanqueLcl("LclLyon","avenu lyon","69000");
		service.addBanque(cic);
		service.addBanque(bnp);
		service.addBanque(lcl);
		assertNotNull(cic.getIdBanque());
		assertNotNull(bnp.getIdBanque());
		assertNotNull(lcl.getIdBanque());
	}
	@Test
	public void testAddBanqueToCompte() {
		 service.addBanqueToCompte(1L, 1L);
		 service.addBanqueToCompte(2L, 1L);
		 service.addBanqueToCompte(3L, 1L);
		 service.addBanqueToCompte(4L, 2L);
		 service.addBanqueToCompte(5L, 3L);
	}
	*/
	
    @Test
	public void testgetCompteByBanque() {
		List<Compte> tabc = service.getListComptes(1L);
		List<Compte> tabc1 = service.getListComptes(2L);
		List<Compte> tabc2 = service.getListComptes(3L);
		assertTrue(tabc.size()>0);
	}
  
	
	

}
