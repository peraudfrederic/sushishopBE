package com.fitec.tp.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fitec.tp.entity.Commande;
import com.fitec.tp.service.IServiceCommande;


@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations={"/applicationContext.xml"})
@ContextConfiguration(locations={"/jpaSpringConf.xml"}) // on ne cherche que la sous-partie
public class TestServiceCommande {

	@Autowired
	private IServiceCommande serviceCommande; // � tester
	
	/*
	 * D'habitude, on met @Before
	 * Ici, grace aux annotations qu'on a mises (@RunWith et @ContextConfiguration), on n'en n'a pas besoin
	 * Ceci ameliore les performances : charg� en memoire qu'une seule fois
	 * @Before ou @BeforeClass
	 * public void test() {
			SpringContext ctx = new ClassPathXmlApplicationContext... etc
	 * }	
	 */
	
	@Test
	public void testRechercherCommande(){
		Commande c = serviceCommande.rechercherCommande(1);
		Assert.assertTrue(c.getId() == 1);
		System.out.println(c.toString());
		
	}
	
//	@Test
//	public void testCreerCommande(){
//		Commande c = serviceCommande.rechercherCommande(1);
//		Assert.assertTrue(c.getId() == 1);
//		System.out.println(c.toString());
//		
//	}
	
}
