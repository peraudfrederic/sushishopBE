package com.fitec.tp.rest;

import java.util.List;

import javax.ws.rs.Consumes;
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
import com.fitec.tp.entity.User;
import com.fitec.tp.service.IServiceUser;


@Path("/users")
@Produces("application/json")
@Consumes("application/json")
@CrossOriginResourceSharing(allowAllOrigins = true)
@Component	//ou @Service : pour prise en charge par spring 
public class ServiceUserRest {

	@Autowired
	private IServiceUser serviceUser;	//service interne
	//private ServiceUserImpl serviceUser;	//service interne
	// ou private IDaoAuteur daoAuteur
	
	/*@GET
	@Path("/{id}")
	// url complete : http://localhost:8080/sushiShop/services/rest/auteurs/1
	// ou services est configur� dans web.xml et rest dans restSpringConfig et 1 est l'id pour exemple
	public Auteur rechercherAuteur(@PathParam("id")int id) {
		return serviceAuteur.rechercherAuteur(id);
	}*/
	
	@GET
	@Path("/all")
	// url complete : http://localhost:8080/sushiShop/services/rest/users/all
	// ou services est configur� dans web.xml et rest dans restSpringConfig et 1 est l'id pour exemple
	public List<User> selectAll() {
		return serviceUser.selectAll();
	}
	
	/*@DELETE
	@Path("/{id}")
	// url complete : http://localhost:8080/sushiShop/services/rest/auteurs/1
	// ou services est configur� dans web.xml et rest dans restSpringConfig et 1 est l'id pour exemple
	public Response supprimerAuteur(@PathParam("id")int id) {
		try {
			serviceAuteur.supprimerAuteur(id);
			return Response.status(Status.OK).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Status.NOT_FOUND).build();   // ou BAD_REQUEST
		}
		
	}*/
	
	/*
 	@PUT
	@Path("/{id}")
	// url complete : http://localhost:8080/sushiShop/services/rest/users/1
	// ou services est configur� dans web.xml et rest dans restSpringConfig et 1 est l'id pour exemple
	public Response modifyUseur(@PathParam("id")int id, User user) {
		try {
			//serviceUser.ajouterUser(user);
			return Response
					.status(Status.OK)
					.entity(user)
					.build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Status.BAD_REQUEST).build();
		}
		
	}
	 */
	
	@PUT
	@Path("/")
	// url complete : http://localhost:8080/sushiShop/services/rest/users/
	// ou services est configur� dans web.xml et rest dans restSpringConfig
	public Response logUseur(User user) {
		try {
			user = serviceUser.seConnecter(user);
			return Response
					.status(Status.OK)
					.entity(user)
					.build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Status.BAD_REQUEST).build();
		}
		
	}
	
	@POST
	@Path("/")
	@CrossOriginResourceSharing(allowAllOrigins = true)
	// url complete : http://localhost:8080/sushiShop/services/rest/users/
	// ou services est configur� dans web.xml et rest dans restSpringConfig
	public Response createUseur(User user) {
		try {
			user = serviceUser.ajouterUser(user);
			return Response
					.status(Status.OK)
					.entity(user)
					.build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Status.BAD_REQUEST).build();   // ou BAD_REQUEST CONFLICT
		}
		
	}
	
	@GET
	@Path("/{id}") // ce parametre vient de @PathParam("id")
	// url complete : http://localhost:8080/wsSpringCxfWeb/services/rest/auteurs/1 : 
	// --> "services" vient de web.xml; 
	// --> "rest" = path sur cette classe; 1=id
	// --> "rest" vient de restSpringConf.xml
	public User rechercherUser(@PathParam("id")int id){ // retourne un objet de type Auteur
		return serviceUser.rechercherUser(id);
	}
	
}
