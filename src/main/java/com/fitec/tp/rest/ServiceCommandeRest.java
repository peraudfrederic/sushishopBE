package com.fitec.tp.rest;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fitec.tp.entity.Commande;
import com.fitec.tp.entity.LigneCommande;
import com.fitec.tp.entity.LignePanier;
import com.fitec.tp.entity.Produit;
import com.fitec.tp.entity.User;
import com.fitec.tp.service.IServiceCommande;
import com.fitec.tp.service.IServiceLigneCommande;
import com.fitec.tp.service.IServiceProduit;
import com.fitec.tp.service.IServiceUser;


@Path("/commandes")
@Produces("application/json") // format renvoy�
@Component // ou @Service : pour prise en charge par Spring
@Consumes("application/json") 
@CrossOriginResourceSharing(allowAllOrigins = true)
public class ServiceCommandeRest {
	
	@Autowired
	private IServiceCommande serviceCommande; // service interne (appel� en interne)
	// ou private IDaoCommande daoCommande; // dao interne
	
	@Autowired
	private IServiceLigneCommande serviceLigneCommande;
	
	@Autowired
	private IServiceUser serviceUser;
	
	@Autowired
	private IServiceProduit serviceProduit;
	
	@GET
	@Path("/{id}") // ce parametre vient de @PathParam("id")
	// url complete : http://localhost:8080/sushiShop/services/rest/commandes/1
	// --> "services" vient de web.xml; 
	// --> "rest" = path sur cette classe; 1=id
	// --> "rest" vient de restSpringConf.xml
	public Commande rechercherCommande(@PathParam("id")int id){ // retourne un objet de type Commande
		return serviceCommande.rechercherCommande(id);
	}
	
	@GET
	@Path("/user/{id}") // ce parametre vient de @PathParam("id")
	// url complete : http://localhost:8080/sushiShop/services/rest/commandes/user/1
	// --> "services" vient de web.xml; 
	// --> "rest" = path sur cette classe; 1=id
	// --> "rest" vient de restSpringConf.xml
	public List<Commande> rechercherCommandeByUser(@PathParam("id")int id){ // retourne une liste de type Commande
		User user = new User();
		user.setId(id);
		return serviceCommande.rechercherCommandeByUser(user);
	}
	
	@GET
	@Path("/all")
	// url complete : http://localhost:8080/sushiShop/services/rest/commandes/all
	public List<Commande> rechercherToutesLesCommande(){
		return serviceCommande.selectAll();
	}
	
	@POST
	@Path("/")
	public Response insererCommande(Commande commande){ // Response est le type de donn�es pr�d�finie de jx-rs
		try{
			serviceCommande.ajouterCommande(commande);
			return Response
					.status(Status.OK) // renvoie le statut
					.entity(commande) // la partie de la donn�e qu'on renvoie
					.build();
		}
		catch(Exception e){
			e.printStackTrace();			
//			return Response.status(Status.BAD_REQUEST).build();
			return Response.status(Status.CONFLICT).build(); 
			// l'avantage de retourner Response (on aurait pu mettre un void ): 
			// si �a va, retourne statut et donn�es
			// si exception, retourne statut
		}
	}	
	
	@POST
	@Path("/panier")
	@CrossOriginResourceSharing(allowAllOrigins = true)
	// url complete : http://localhost:8080/sushiShop/services/rest/commandes/panier
	// ou services est configur� dans web.xml et rest dans restSpringConfig
	public Response createPanier(List<LignePanier> panier) {
		try {
			
			//on créé une commande à partir des informations du panier
			Commande cmd = new Commande();
			cmd.setDate(new Date());
			User usr = serviceUser.rechercherUser(panier.get(0).getIdUser());
			cmd.setId_user(usr);
			Set<LigneCommande> lignesCommande = new HashSet<LigneCommande>();			
	
			// on verifie si le stock est suffisant pour satisfaire la demande
			for(LignePanier l : panier) {
				LigneCommande lc = new LigneCommande(0, cmd, serviceProduit.rechercherProduit(l.getIdProduit()), l.getQuantite(), l.getPrix());
				
				int quantiteCommandee = lc.getQuantite(); // pour chaque LignePanier, la quantité commandée
				Produit idProduit = lc.getId_produit(); // pour chaque LignePanier, son id_produit	
				
				if(!serviceProduit.verifierStock(idProduit, quantiteCommandee)){
					return Response.status(Status.BAD_REQUEST).build();   // ou BAD_REQUEST CONFLICT
				}
				else{
					lignesCommande.add(lc); // on ajoute
				}
			}			
			
//			for(LignePanier l : panier) {
//				LigneCommande lc = new LigneCommande(0, cmd, serviceProduit.rechercherProduit(l.getIdProduit()), l.getQuantite(), l.getPrix());
//				lignesCommande.add(lc);
//			}
			

			//on n'insere pas le tableau de ligne commande dans la commande
			// car sinon plantage car ligneCommande sans vrai ID
			//cmd.setLignesCommande(lignesCommande);
			
			// on la persiste en BDD
			cmd = serviceCommande.ajouterCommande(cmd);
			
			// on met à jours l'ID de la commande pour chaque ligne de commande et on la persiste en BDD
			//lignesCommande.forEach(lc -> lc.setId_commande(cmd));
			for(LigneCommande lc : lignesCommande)
			{
				lc.setId_commande(cmd);
				
				serviceLigneCommande.ajouterLigneCommande(lc);
				
				/////////////////////////////////////////
				// Mise a jour du stock :
				int quantiteCommandee = lc.getQuantite(); // pour chaque LigneCommande, la quantité commandée
				Produit idProduit = lc.getId_produit(); // pour chaque LigneCommadnde, son id_produit					
				serviceProduit.majStock(idProduit, quantiteCommandee); 				
				//////////////////////////////////////////
			}
			
			return Response
					.status(Status.OK)
					.entity(panier) // pour l'instant, on laisse même si null, juste pour tester
					.build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Status.BAD_REQUEST).build();   // ou BAD_REQUEST CONFLICT
		}		
	}
	
	
//	@DELETE
//	@Path("/delete")
//	public Response supprimerAuteur(@PathParam("id")int id, Auteur auteur){ // Response est le type de donn�es pr�d�finie de jx-rs
//		try{
//			serviceAuteur.supprimerAuteur(id);
//			return Response
//					.status(Status.OK) // renvoie le statut
//					.entity(auteur) // la partie de la donn�e qu'on renvoie
//					.build();
//		}
//		catch(Exception e){
//			e.printStackTrace();			
////			return Response.status(Status.BAD_REQUEST).build();
//			return Response.status(Status.NOT_FOUND).build(); 
//			// l'avantage de retourner Response (on aurait pu mettre un void ): 
//			// si �a va, retourne statut et donn�es
//			// si exception, retourne statut
//		}
//	}

	
//	@PUT
//	@Path("/{id}")
//	//url complete : http://localhost:8080/wsSpringCxfWeb/services/rest/auteurs/1
//	//o� services est configur� dans web.xml et rest dans restSpringConf.xml
//	public Response majAuteur(@PathParam("id")int id,Auteur auteur){
//		try {
//			serviceAuteur.majAuteur(auteur);
//			return Response
//					.status(Status.OK)
//					.entity(auteur) //partie "donn�e" de la r�ponse renvoy�e
//					.build();
//		} catch (Exception e) {
//			e.printStackTrace();
//			return Response.status(Status.NOT_FOUND).build();
//			//return Response.status(Status.BAD_REQUEST).build();
//		}
//	}	

}

