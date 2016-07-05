package com.adaming.gestiondescomptes;

import static org.junit.Assert.assertNotNull;

import java.util.Collection;
import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.adaming.gestiondescomptes.entitis.Client;
import com.adaming.gestiondescomptes.entitis.Employe;
import com.adaming.gestiondescomptes.service.client.IclientService;
import com.adaming.gestiondescomptes.service.employe.IemployeService;

public class Test {

	private static ClassPathXmlApplicationContext context;
	private static IclientService service;

	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("app.xml");
		service = (IclientService) context.getBean("serviceClient");
        
		Client c = new Client("bounajama","sara",new Date(),"Avenu jean jaures");
	
		service.addClient(c);
	
	
	}
	

}
