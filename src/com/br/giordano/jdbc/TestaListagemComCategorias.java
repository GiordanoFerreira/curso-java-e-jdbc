package com.br.giordano.jdbc;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.br.giordano.jdbc.dao.CategoriaDAO;
import com.br.giordano.jdbc.factory.ConnectionFactory;
import com.br.giordano.jdbc.modelo.Categoria;
import com.br.giordano.jdbc.modelo.Produto;

public class TestaListagemComCategorias {
	public static void main(String[] args) throws SQLException {

		try (Connection connection = new ConnectionFactory().recuperarConexao()) {
			CategoriaDAO categoriaDAO = new CategoriaDAO(connection);
			
			List<Categoria> listaDeCategorias = categoriaDAO.listarComProdutos();

			listaDeCategorias.stream().forEach(ct -> {

				System.out.println(ct.getNome());

				for (Produto produto : ct.getProdutos()) {
					System.out.println(ct.getNome() + " - " + produto);
				}

			});
		}
	}
}
