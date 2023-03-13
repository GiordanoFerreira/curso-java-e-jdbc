package com.br.giordano.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.br.giordano.jdbc.factory.ConnectionFactory;

public class TestaRemocao {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.recuperarConexao();
		
		PreparedStatement stm = connection.prepareStatement("DELETE FROM produto WHERE ID > 2");
		
		stm.execute();
		
		Integer linhasModificadas = stm.getUpdateCount();
		
		System.out.println("O numero de linhas modificadas foram: " + linhasModificadas);
		
		connection.close();
	}
}
