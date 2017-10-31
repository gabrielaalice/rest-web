package br.codeforfloripa.rest;

import javax.annotation.PostConstruct;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import br.codeforfloripa.dao.UsuarioDAO;
import br.codeforfloripa.entity.Person;
import br.codeforfloripa.entity.User;

@Path("/user")
public class UsuarioService {

	private UsuarioDAO usuarioDAO;

	@PostConstruct
	private void init() {
		usuarioDAO = new UsuarioDAO();
	}

	@POST
	@Path("/login")
	@Produces(MediaType.TEXT_PLAIN)
	public boolean isLoggedIn(@QueryParam("email") String email, @QueryParam("senha") String senha) {
		try {
			return usuarioDAO.isLoggedIn(email, senha);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void add(User user) throws Exception {
		usuarioDAO.addUser(user);
	}

}
