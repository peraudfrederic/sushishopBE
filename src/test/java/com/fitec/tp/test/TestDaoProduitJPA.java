package com.fitec.tp.test;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import com.fitec.tp.dao.DaoProduitJPA;
import com.fitec.tp.entity.Produit;

public class TestDaoProduitJPA {

	private DaoProduitJPA produit;
	private Session session ;
	
	@Before
	public void setUp() throws Exception {
		
		produit = new DaoProduitJPA();
	}
	

	 /* ==========================
	  * Instanciation de la Dao 
	 * ===========================*/
	@Test 
	public void testInstanciationDao() {
		
		assertNotNull("Dao non créé, produit"); 
		
	}
	
	 /* ==========================
	  * Select All Produit
	 * ===========================*/	
	@Test
	public void testSelectAllProduit(){
		List<Produit> produits = produit.selectAll();
		
		for (Produit p : produits) {
			System.out.println(p.getLibelle());
		}
	}
	
	

}
