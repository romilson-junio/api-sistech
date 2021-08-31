package br.com.sistech.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.sistech.model.Produto;
import io.quarkus.panache.common.Sort;

@RequestScoped
public class ProdutoDao {
	/**
	 * Injeções
	 */
	@PersistenceContext
	EntityManager em;
	public List<Produto> listarProdutos() {
		// TODO Auto-generated method stub
		return Produto.listAll(Sort.by("codigo").ascending());
		
	}
	public void incluirProduto(Produto produto) {
		// TODO Auto-generated method stub
		Produto.persist(produto);
	}
}
