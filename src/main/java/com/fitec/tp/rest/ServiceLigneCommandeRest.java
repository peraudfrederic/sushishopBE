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

import com.fitec.tp.entity.LigneCommande;
import com.fitec.tp.service.IServiceLigneCommande;


@Path("/lignescommandes")
@Produces("application/json") // format renvoy�
@Component // ou @Service : pour prise en charge par Spring
@Consumes("application/json") 
@CrossOriginResourceSharing(allowAllOrigins = true)
public class ServiceLigneCommandeRest {
	
	@Autowired
	private IServiceLigneCommande serviceLigneCommande; // service interne (appel� en interne)
	// ou private IDaoLigneCommande daoLigneCommande; // dao interne
	
	@GET
	@Path("/{id}") // ce parametre vient de @PathParam("id")
	// url complete : http://localhost:8080/wsSpringCxfWeb/services/rest/auteurs/1 : 
	// --> "services" vient de web.xml; 
	// --> "rest" = path sur cette classe; 1=id
	// --> "rest" vient de restSpringConf.xml
	public LigneCommande rechercherLigneCommande(@PathParam("id")int id){ // retourne un objet de type Auteur
		return serviceLigneCommande.rechercherLigneCommande(id);
	}
	
	@GET
	@Path("/all")
	public List<LigneCommande> rechercherTousLesProduits(){
		return serviceLigneCommande.selectAll();
	}
	
	@POST
	@Path("/")
	public Response insererLigneCommande(LigneCommande lc){ // Response est le type de donn�es pr�d�finie de jx-rs
		try{
			serviceLigneCommande.ajouterLigneCommande(lc);
			return Response
					.status(Status.OK) // renvoie le statut
					.entity(lc) // la partie de la donn�e qu'on renvoie
					.build();
		}
		catch(Exception e){
			e.printStackTrace();			
			// return Response.status(Status.BAD_REQUEST).build();
			return Response.status(Status.CONFLICT).build(); 
			// l'avantage de retourner Response (on aurait pu mettre un void ): 
			// si �a va, retourne statut et donn�es
			// si exception, retourne statut
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

