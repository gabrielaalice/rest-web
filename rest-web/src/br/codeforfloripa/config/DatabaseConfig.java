package br.codeforfloripa.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {
	
private static DatabaseConfig config;
	
	public static DatabaseConfig getInstance() {
		if (config == null) {
			config = new DatabaseConfig();
		}
		return config;
	}
	
	public Connection getConnection() throws SQLException, ClassNotFoundException {
		
		 //Testa sua conexão//  
		Connection connection = null; 
		try {
		 
		// Carregando o JDBC Driver padrão
		 
			Class.forName("com.mysql.jdbc.Driver");
		 
		// Configurando a nossa conexão com um banco de dados//
		 
		          
		 
		            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/firecast", "root", "1234");

		 
		            //Testa sua conexão//  
		 
		            if (connection != null) {
		 
		                System.out.println("STATUS--->Conectado com sucesso!");
		 
		            } else {
		 
		            	System.out.println("STATUS--->Não foi possivel realizar conexão");
		 
		            }
		 
		  
		 
		            return connection;
		 
		  
		 
		        } catch (ClassNotFoundException e) {  //Driver não encontrado
		 
		  
		 
		            System.out.println("O driver expecificado nao foi encontrado.");
		 
		            return null;
		 
		        } catch (SQLException e) {
		 
		//Não conseguindo se conectar ao banco
		 
		            System.out.println("Nao foi possivel conectar ao Banco de Dados.");
		 
		            return null;
		 
		        }
		 
	
	}
}
