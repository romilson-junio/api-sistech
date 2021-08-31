package br.com.sistech.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.sistech.model.Pedido;
import io.quarkus.panache.common.Sort;

@RequestScoped
public class PedidoDao {
	/**
	 * Injeções
	 */
	@PersistenceContext
	EntityManager em;
	public List<Pedido> listarPedidos() {
		// TODO Auto-generated method stub
		return Pedido.listAll(Sort.by("id").ascending());
		
	}
	public void incluirPedido(Pedido pedido) {
		// TODO Auto-generated method stub
		Pedido.persist(pedido);
		
	}
}
