package com.fitec.tp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fitec.tp.entity.Commande;
import com.fitec.tp.entity.LigneCommande;


@Component // ou bien @Repository
@Transactional // version Spring: c'est Spring qui va gerer les transaction dans la bdd. Pour cela il faudra un TransactionManager (voir fichier jpaSpringConf)
public class DaoLigneCommande implements IDaoLigneCommande{
	
	@PersistenceContext(unitName="myPersistenceUnit") // injection de dependances et initialisation de la connexion a la bdd
	private EntityManager entityManager; // de JPA. Dans le programme, tout se fera a partir de EntityManager

	@Override
	public List<com.fitec.tp.entity.LigneCommande> selectAll() {
		// return entityManager.createQuery("SELECT * FROM Auteur a", Auteur.class).getResultList();
		return entityManager.createNamedQuery("ligne_commande.all" , LigneCommande.class).getResultList(); // avec NamedQuery
	}
	
	@Override
	public com.fitec.tp.entity.LigneCommande selectById(int id) {
		return entityManager.find(LigneCommande.class, id);
	}

	@Override
	public LigneCommande insertLigneCommande(LigneCommande lc) {
		lc = entityManager.merge(lc); // fait save or update
		// la cl� primaire auto-incr�ment�e par mysql
		// remonte dans l'objet java lors du .persist()
		// grace � @GeneratedValue() sur l'id de l'Auteur
		return lc;
	}

	@Override
	public List<LigneCommande> selectByCommande(Commande idCommande) {
		
		List<LigneCommande> lignesCommandes = entityManager.createNamedQuery("ligne_commande.idCommande", LigneCommande.class)
				.setParameter("id_commande", idCommande)
				.getResultList();
		
		return lignesCommandes;
	}

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
//	// entityManager.getTransaction().beguin(); // effectu� via @Transactional donc pas besoin de gerer les transactions
//		entityManager.merge(p);
//		
//	}

}

