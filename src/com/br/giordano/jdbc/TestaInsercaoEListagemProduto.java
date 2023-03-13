package com.br.giordano.jdbc;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.br.giordano.jdbc.dao.ProdutoDAO;
import com.br.giordano.jdbc.factory.ConnectionFactory;
import com.br.giordano.jdbc.modelo.Produto;

public class TestaInsercaoEListagemProduto {

	public static void main(String[] args) throws SQLException {

		Produto mouse = new Produto("MESA", "MESA DE MARMORE");

		try (Connection connection = new ConnectionFactory().recuperarConexao()) {
			ProdutoDAO produtoDao = new ProdutoDAO(connection);
			produtoDao.salvar(mouse);
			List<Produto> listaDeProdutos = produtoDao.listar();
			listaDeProdutos.stream().forEach(lp -> {

				System.out.println(lp);
			});
		}
	}
}
