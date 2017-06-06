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

import com.fitec.tp.entity.Produit;
import com.fitec.tp.service.IServiceProduit;

@Path("/produits")
@Produces("application/json") // format renvoyé
@Component // ou @Service : pour prise en charge par Spring
@Consumes("application/json") 
@CrossOriginResourceSharing(allowAllOrigins = true)
public class ServiceProduitRest {
	
	@Autowired
	private IServiceProduit serviceProduit; // service interne (appelé en interne)
	// ou private IDaoAuteur daoAuteur; // dao interne
	
	@GET
	@Path("/{id}") // ce parametre vient de @PathParam("id")
	// url complete : http://localhost:8080/wsSpringCxfWeb/services/rest/auteurs/1 : 
	// --> "services" vient de web.xml; 
	// --> "rest" = path sur cette classe; 1=id
	// --> "rest" vient de restSpringConf.xml
	public Produit rechercherProduit(@PathParam("id")int id){ // retourne un objet de type Auteur
		return serviceProduit.rechercherProduit(id);
	}
	
	@GET
	@Path("/all")
	public List<Produit> rechercherTousLesProduits(){
		return serviceProduit.selectAll();
	}
	
//	@DELETE
//	@Path("/delete")
//	public Response supprimerAuteur(@PathParam("id")int id, Auteur auteur){ // Response est le type de données prédéfinie de jx-rs
//		try{
//			serviceAuteur.supprimerAuteur(id);
//			return Response
//					.status(Status.OK) // renvoie le statut
//					.entity(auteur) // la partie de la donnée qu'on renvoie
//					.build();
//		}
//		catch(Exception e){
//			e.printStackTrace();			
////			return Response.status(Status.BAD_REQUEST).build();
//			return Response.status(Status.NOT_FOUND).build(); 
//			// l'avantage de retourner Response (on aurait pu mettre un void ): 
//			// si ça va, retourne statut et données
//			// si exception, retourne statut
//		}
//	}
//
//	@POST
//	@Path("/")
//	public Response insererAuteur(Auteur auteur){ // Response est le type de données prédéfinie de jx-rs
//		try{
//			serviceAuteur.ajouterAuteur(auteur);
//			return Response
//					.status(Status.OK) // renvoie le statut
//					.entity(auteur) // la partie de la donnée qu'on renvoie
//					.build();
//		}
//		catch(Exception e){
//			e.printStackTrace();			
////			return Response.status(Status.BAD_REQUEST).build();
//			return Response.status(Status.CONFLICT).build(); 
//			// l'avantage de retourner Response (on aurait pu mettre un void ): 
//			// si ça va, retourne statut et données
//			// si exception, retourne statut
//		}
//	}	
//	
//	@PUT
//	@Path("/{id}")
//	//url complete : http://localhost:8080/wsSpringCxfWeb/services/rest/auteurs/1
//	//où services est configuré dans web.xml et rest dans restSpringConf.xml
//	public Response majAuteur(@PathParam("id")int id,Auteur auteur){
//		try {
//			serviceAuteur.majAuteur(auteur);
//			return Response
//					.status(Status.OK)
//					.entity(auteur) //partie "donnée" de la réponse renvoyée
//					.build();
//		} catch (Exception e) {
//			e.printStackTrace();
//			return Response.status(Status.NOT_FOUND).build();
//			//return Response.status(Status.BAD_REQUEST).build();
//		}
//	}	

}
