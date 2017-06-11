package com.fitec.tp.rest;

import java.util.List;

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
import com.fitec.tp.entity.LignePanier;
import com.fitec.tp.entity.Panier;
import com.fitec.tp.entity.User;
import com.fitec.tp.service.IServiceCommande;


@Path("/commandes")
@Produces("application/json") // format renvoy�
@Component // ou @Service : pour prise en charge par Spring
@Consumes("application/json") 
@CrossOriginResourceSharing(allowAllOrigins = true)
public class ServiceCommandeRest {
	
	@Autowired
	private IServiceCommande serviceCommande; // service interne (appel� en interne)
	// ou private IDaoCommande daoCommande; // dao interne
	
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
	public List<Commande> rechercherCommandeByUser(@PathParam("id")int id){ // retourne un objet de type Commande
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
	@Path("/panier2")
	@CrossOriginResourceSharing(allowAllOrigins = true)
	// url complete : http://localhost:8080/sushiShop/services/rest/commandes/panier
	// ou services est configur� dans web.xml et rest dans restSpringConfig
	public Response createPanier(Panier panier) {
		try {
			// enregistrerPanier(Panier panier)
			//panier = serviceCommande.enregistrerPanier(panier);
			serviceCommande.enregistrerPanier(panier);
			return Response
					.status(Status.OK)
					.entity(panier) // pour l'instant, on laisse même si null, juste pour tester
					.build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Status.BAD_REQUEST).build();   // ou BAD_REQUEST CONFLICT
		}		
	}	
	
	
	@POST
	@Path("/panier")
	@CrossOriginResourceSharing(allowAllOrigins = true)
	// url complete : http://localhost:8080/sushiShop/services/rest/commandes/panier
	// ou services est configur� dans web.xml et rest dans restSpringConfig
	public Response createPanier(LignePanier[] panier) {
		try {
			// enregistrerPanier(Panier panier)
			//panier = serviceCommande.enregistrerPanier(panier);
			serviceCommande.enregistrerPanier(panier);
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

