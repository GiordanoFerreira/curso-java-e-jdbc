package com.br.giordano.jdbc;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.br.giordano.jdbc.factory.ConnectionFactory;

public class TestaInsercao {
	
	public static void main(String[] args) throws SQLException{
		
		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.recuperarConexao();
		
		Statement stm = connection.createStatement();
		
		stm.execute("INSERT INTO produto (nome, descricao) VALUES ('MOUSE RAZER', 'RAZER VIPER')", Statement.RETURN_GENERATED_KEYS);
		
		ResultSet rst = stm.getGeneratedKeys();
		
		while(rst.next()) {
			Integer id = rst.getInt(1);
			System.out.println("O id criado foi: " + id);
		}
		
		/*stm.execute("SELECT * FROM produto");
		
	    rst = stm.getResultSet();
		
	    while(rst.next()) {
	    	Integer id = rst.getInt("ID");
	    	System.out.println(id);
	    	String nome = rst.getString("NOME");
	    	System.out.println(nome);
	    	String descricao = rst.getString("DESCRICAO");
	    	System.out.println(descricao);
	    }*/
	    
		connection.close();	
	}
}
