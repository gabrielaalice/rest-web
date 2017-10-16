package br.codeforfloripa.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import br.codeforfloripa.entity.Person;
import br.codeforfloripa.util.Constantes;


@Path("/alo")
	public class AloMundoService {
		
		@GET
		@Path("/alo2")
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