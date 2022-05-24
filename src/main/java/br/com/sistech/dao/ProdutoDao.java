package br.com.sistech.dao;

import java.util.HashMap;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.sistech.model.Cliente;
import br.com.sistech.model.ItensPedido;
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

	public Produto consultarProduto(String produtoFind){
		String nomeSql = "CONSULTAR_PRODUTO";
		Produto produto;
		TypedQuery<Produto> query = em.createNamedQuery(nomeSql, Produto.class);
		query.setParameter("produto", produtoFind);
		return query.getSingleResult();
	}

	public List<ItensPedido> consultarItensVendidos(){
		return ItensPedido.listAll();
	}
}
