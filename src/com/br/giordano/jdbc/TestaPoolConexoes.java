package com.br.giordano.jdbc;
import java.sql.SQLException;

import com.br.giordano.jdbc.factory.ConnectionFactory;

public class TestaPoolConexoes {
	
	public static void main(String[] args) throws SQLException{
		
		ConnectionFactory connection = new ConnectionFactory();
		
		for(int i = 1; i < 20; i++) {
			connection.recuperarConexao();
			System.out.println("Numero de conexao: " + i);
		}
	}
}
