package com.br.giordano.jdbc;
import java.sql.Connection;
import java.sql.SQLException;

import com.br.giordano.jdbc.factory.ConnectionFactory;

public class TestaConexao {
	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.recuperarConexao();
		
		System.out.println("Fechando Conexao!");
		
		connection.close();	
	}
}
