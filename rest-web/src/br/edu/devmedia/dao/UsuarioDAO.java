package br.edu.devmedia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.edu.devmedia.config.DatabaseConfig;
import br.edu.devmedia.rest.CriptoUtil;


public class UsuarioDAO {

	public boolean isLoggedIn(String usuario, String senha) throws Exception {
		Connection conexao = DatabaseConfig.getInstance().getConnection();

		String sql = "SELECT * FROM TB_USUARIO WHERE USUARIO = ? AND SENHA = ?";

		PreparedStatement statement = conexao.prepareStatement(sql);
		statement.setString(1, usuario);
		statement.setString(2, CriptoUtil.criptoStringHexMD5(senha));

		ResultSet resultSet = statement.executeQuery();

		return resultSet.next();
	}

}
