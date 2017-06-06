package com.fitec.tp.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fitec.tp.entity.User;
import com.fitec.tp.service.IServiceUser;


//import junit.framework.Assert;

//nï¿½cessite spring-test.jar et junit4.8.1.jar dans le classpath 
@RunWith(SpringJUnit4ClassRunner.class) 
// ApplicationContext will be loaded from "/mySpringConf.xml" in the root of the classpath 
@ContextConfiguration(locations={"/jpaSpringConf.xml"})
public class TestServiceUser {
	
	@Autowired
	//private ServiceUserImpl serviceUser;	// le service ï¿½ tester
	private IServiceUser serviceUser;	// le service ï¿½ tester

	/* plus necessaire : remplacï¿½ par les annotation @runwith et @contextConfig
	@Before ou @BeforeClass
	public void init() {
		SpringContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
		ServiceAuteur = ctx.getBean(IServiceUser.class);
	}
	*/
	
	@Test
	public void testRechercherUsers() {
		
		List<User> l = serviceUser.selectAll();
		
		assertNotNull(l);
		l.forEach(x -> System.out.println(x));
		//assertTrue(a.getId() == 1);
		
	}
	
	
	@Test
	public void testAjouterUser() {
		
		User usr = new User();
		usr.setNom("derf");
		usr.setPrenom("fred");
		usr.setEmail("fred@derf.com");
		usr.setMdp("fred");
		usr.setIsAdmin(false);
		
		User usrAdded = serviceUser.ajouterUser(usr);
		assertNotNull(usrAdded.getId());
		
		//assertNotNull(l);
		//l.forEach(x -> System.out.println(x));
		//assertTrue(a.getId() == 1);
		
	}
	
	@Test
	public void testConnecterUser() {
		
		User usr = new User();
		usr.setEmail("fred@derf.com");
		usr.setMdp("fred");
		User connectedUsr = serviceUser.seConnecter(usr);
		assertNotNull(connectedUsr);
		
		System.out.println("connecté !");
		
		usr.setMdp("sdlkfg");
		connectedUsr = serviceUser.seConnecter(usr);
		assertNull(connectedUsr);
		
		System.out.println("non connecté !");
		
				
	}
	
	
	
}
