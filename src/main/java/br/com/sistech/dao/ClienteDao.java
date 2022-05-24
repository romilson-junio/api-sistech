package br.com.sistech.dao;

import br.com.sistech.model.Cliente;
import io.quarkus.panache.common.Sort;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;


@RequestScoped
public class ClienteDao {
	/**
	 * Injeções
	 */
	@PersistenceContext
	EntityManager em;

	public List<Cliente> listarClientes() {
		// TODO Auto-generated method stub
		
		return Cliente.listAll(Sort.by("id, nome, email, cpf").ascending());
		
	}
	public List<Cliente> buscarCliente(String cpf) {
		String nomeSql = "CONSULTAR_CLIENTE";
		List<Cliente> clientes;
		TypedQuery<Cliente> query = em.createNamedQuery(nomeSql, Cliente.class);
		query.setParameter("cpf", cpf);
		try {
			clientes = query.getResultList();
		} catch (NoResultException e) {
			clientes = null;
		}
		return clientes;
	}

	public void incluirCliente(Cliente novoCliente) {
		Cliente.persist(novoCliente);
	}
}
