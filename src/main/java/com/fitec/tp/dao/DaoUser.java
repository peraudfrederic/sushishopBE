package com.fitec.tp.dao;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fitec.tp.entity.Produit;
import com.fitec.tp.entity.User;

@Component 		//ou bien @Repository
@Transactional  //version spring
public class DaoUser implements IDaoUser {

	@PersistenceContext(unitName="myPersistenceUnit")		//injection + initialisation connexion base
	private EntityManager entityManager;	//de JPA
	
	/*@Override
	public Auteur selectById(int id) {
		return entityManager.find(Auteur.class, id);
	}*/

	//@Override
	public List<User> selectAll() {
		
		// marcherai mais en passant par les named query (dans le fichier auteur) c'est + rapide
		//return entityManager.createQuery("SELECT a FROM Auteur a", Auteur.class).getResultList();
		
		return entityManager.createNamedQuery("user.all", User.class)
				//.setParameter(...,...)
				.getResultList();
	}

	//@Override
	public User insert(User u) {
		
		try {
			// id auto-incremented grace � @GeneratedValue
			//entityManager.persist(u);
			u = entityManager.merge(u);
		}
		catch (Exception ex) {
			Logger.getLogger(DaoUser.class.getName()).log(Level.SEVERE, ex.getLocalizedMessage(), ex);
			throw (ex);
		}
		
		return u;
	}
	
	
	public User selectByEmail(String mail) {
		
		// marcherai mais en passant par les named query (dans le fichier auteur) c'est + rapide
		//return entityManager.createQuery("SELECT a FROM Auteur a", Auteur.class).getResultList();
		
		User usr = null;
		
		List<User> users = entityManager.createNamedQuery("user.mail", User.class)
				.setParameter("email", mail)
				.getResultList();
		
		if(users.size() > 0)
			usr = users.get(0);
		
		return usr;
	}
	
	
	@Override
	public com.fitec.tp.entity.User selectById(int id) {
		return entityManager.find(User.class, id);
	}
	

	/*@Override
	public void deleteAuteur(int id) {

		Auteur a = entityManager.find(Auteur.class, id);
		entityManager.remove(a);
		
	}*/

	/*@Override
	public void updateAuteur(Auteur a) {
		// le entityManager.getTransaction().begin()  et .commit est effectu� par le @Transactional
		entityManager.merge(a);
		
	}*/

}
