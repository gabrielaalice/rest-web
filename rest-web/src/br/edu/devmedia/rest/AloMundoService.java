package br.edu.devmedia.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import br.edu.devmedia.entity.Person;


@Path("/alo")
	public class AloMundoService {
		
		@GET
		@Path("/alo2")
		@Produces(MediaType.TEXT_XML)
		@Consumes(MediaType.TEXT_PLAIN)
		public String aloMundoGet2(@QueryParam("msg") String msg) {
			return "COMUNICAÇÃO COM O WS REALIZADA";
		}
		
		@POST
		@Path("/json")	
		@Produces(Constantes.APPLICATION_JSON_UTF8)
		@Consumes(Constantes.APPLICATION_JSON_UTF8)
		public Person testJson(Person p) {
			System.out.println(p.getFirstName());
			
			p.setFirstName("Cláudia");
		
			return p;
		}
}