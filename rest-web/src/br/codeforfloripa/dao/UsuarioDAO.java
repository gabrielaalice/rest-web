package br.codeforfloripa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.codeforfloripa.config.DatabaseConfig;
import br.codeforfloripa.entity.User;
import br.codeforfloripa.util.CriptoUtil;


public class UsuarioDAO {


	public boolean isLoggedIn(String email, String senha) throws Exception {
		
		Connection connection = DatabaseConfig.getInstance().getConnection();

		String sql = "SELECT * FROM user WHERE email = ? AND password = ?";

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, email);
		statement.setString(2, senha);

		ResultSet resultSet = statement.executeQuery();

		return resultSet.next();
	}
	
	public void addUser(User user) throws Exception{  
		
		Connection connection = DatabaseConfig.getInstance().getConnection();
        String sql = "INSERT INTO user(usuario,email,password,confirm_password, distance) VALUES(?,?,?,?,?)";  
        try {  
            PreparedStatement stmt = connection.prepareStatement(sql);  
            stmt.setString(1, user.getName());  
            stmt.setString(2, user.getEmail());  
            stmt.setString(3, user.getPassword());  
            stmt.setString(4, user.getConfirmPassword()); 
            stmt.setInt(5, user.getDistance());  
    
            stmt.execute();  
            stmt.close();  
        } catch (SQLException u) {  
            throw new RuntimeException(u);  
    }  
	}

}

