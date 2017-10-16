package br.codeforfloripa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.codeforfloripa.config.DatabaseConfig;
import br.codeforfloripa.util.CriptoUtil;


public class UsuarioDAO {

	public boolean isLoggedIn(String usuario, String senha) throws Exception {
		Connection conexao = DatabaseConfig.getInstance().getConnection();

		String sql = "SELECT * FROM user WHERE USUARIO = ? AND password = ?";

		PreparedStatement statement = conexao.prepareStatement(sql);
		statement.setString(1, usuario);
		statement.setString(2, senha);

		ResultSet resultSet = statement.executeQuery();

		return resultSet.next();
	}

}

