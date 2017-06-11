package com.fitec.tp.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fitec.tp.entity.Produit;
import com.fitec.tp.service.IServiceProduit;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations={"/applicationContext.xml"})
@ContextConfiguration(locations={"/jpaSpringConf.xml"}) // on ne cherche que la sous-partie
public class TestServiceProduit {

	@Autowired
	private IServiceProduit serviceProduit; // � tester
	
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
	public void testRechercherProduit(){
		Produit p = serviceProduit.rechercherProduit(1);
		Assert.assertTrue(p.getId() == 1);
		System.out.println(p.toString());
		
	}
	
	@Test
	public void testRechercherAllProduits(){
		List<Produit> listeProduits = serviceProduit.selectAll();
		
		Assert.assertTrue(!listeProduits.isEmpty());
		
		for(Produit produit : listeProduits){
			System.out.println(produit.toString());
		}
	}
	
}
