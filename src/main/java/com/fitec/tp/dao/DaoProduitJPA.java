package com.fitec.tp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fitec.tp.entity.Produit;

@Component // ou bien @Repository
@Transactional // version Spring: c'est Spring qui va gerer les transaction dans la bdd. Pour cela il faudra un TransactionManager (voir fichier jpaSpringConf)
public class DaoProduitJPA implements IDaoProduit{
	
	@PersistenceContext(unitName="myPersistenceUnit") // injection de dependances et initialisation de la connexion a la bdd
	private EntityManager entityManager; // de JPA. Dans le programme, tout se fera a partir de EntityManager

	@Override
	public List<com.fitec.tp.entity.Produit> selectAll() {
		// return entityManager.createQuery("SELECT * FROM Auteur a", Auteur.class).getResultList();
		return entityManager.createNamedQuery("produit.all" , Produit.class).getResultList(); // avec NamedQuery
	}
	
	@Override
	public com.fitec.tp.entity.Produit selectById(int id) {
		return entityManager.find(Produit.class, id);
	}

//	@Override
//	public Produit insertProduit(Produit p) {
//		entityManager.persist(p);
//		// la clé primaire auto-incrémentée par mysql
//		// remonte dans l'objet java lors du .persist()
//		// grace à @GeneratedValue() sur l'id de l'Auteur
//		return p;
//	}
//
//	@Override
//	public void deleteProduit(int id) {
//		Produit p = entityManager.find(Produit.class, id);
//		entityManager.remove(p);
//		// pour peaufiner, on aurait pu mettre if "id est null..."
//		
//	}
//
//	@Override
//	public void updateProduit(Produit p) {
//	// entityManager.getTransaction().beguin(); // effectué via @Transactional donc pas besoin de gerer les transactions
//		entityManager.merge(p);
//		
//	}

}
