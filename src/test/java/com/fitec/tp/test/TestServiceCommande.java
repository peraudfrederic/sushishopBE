package com.fitec.tp.test;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fitec.tp.entity.Commande;
import com.fitec.tp.entity.User;
import com.fitec.tp.service.IServiceCommande;
import com.fitec.tp.service.IServiceUser;


@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations={"/applicationContext.xml"})
@ContextConfiguration(locations={"/jpaSpringConf.xml"}) // on ne cherche que la sous-partie
public class TestServiceCommande {

	@Autowired
	private IServiceCommande serviceCommande; // � tester
	private IServiceUser serviceUser; // � tester
	
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
		
		System.out.println(c.toStringLignes());
		
	}
	
	@Test
	public void testCreerCommande(){
		User user = new User();
		user.setId(1); // user qui existe dans la bdd
		Date date = new Date();
		Commande commande = new Commande();
		commande.setId_user(user);
		commande.setDate(date);
		Commande c = serviceCommande.ajouterCommande(commande);
		Assert.assertTrue(c.getId() != null);
		System.out.println(c.toString());
		
	}
	
}
