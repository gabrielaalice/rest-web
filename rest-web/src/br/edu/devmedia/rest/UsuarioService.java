package br.edu.devmedia.rest;

import javax.annotation.PostConstruct;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.edu.devmedia.dao.UsuarioDAO;
import br.edu.devmedia.entity.User;

public class UsuarioService {

	private UsuarioDAO usuarioDAO;

	@PostConstruct
	private void init() {
		usuarioDAO = new UsuarioDAO();
	}

	@POST
	@Path("/login")
	@Produces(MediaType.TEXT_PLAIN)
	public boolean isLoggedIn(@FormParam("usuario") String usuario, @FormParam("senha") String senha) {
		try {
			return usuarioDAO.isLoggedIn(usuario, senha);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User add(User user) {
		return user;
	}

	
}
