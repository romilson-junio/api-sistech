package br.com.sistech.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.sistech.model.Cliente;
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

	public List<Pedido> pedidosPorCliente(String cpf){
		String nomeSql = "PEDIDO_POR_CLIENTE";
		List<Pedido> pedidos;
		TypedQuery<Pedido> query = em.createNamedQuery(nomeSql, Pedido.class);
		query.setParameter("cpf", cpf);
		try {
			pedidos = query.getResultList();
		} catch (NoResultException e) {
			pedidos = null;
		}
		return pedidos;
	}
}
