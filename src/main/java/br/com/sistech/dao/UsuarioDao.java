package br.com.sistech.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.sistech.dto.UsuarioDto;
import br.com.sistech.dto.request.UsuarioRequest;
import br.com.sistech.model.Usuario;
import io.quarkus.panache.common.Sort;


@RequestScoped
public class UsuarioDao {
	/**
	 * Injeções
	 */
	@PersistenceContext
	EntityManager em;

	public List<Usuario> listarUsuarios() {
		// TODO Auto-generated method stub
		
		return Usuario.listAll(Sort.by("id, nome, email, senha, perfil").ascending());
		
	}

	public Usuario buscarUsuario(UsuarioRequest usuarioLogin) {

		String nomeSql = "CONSULTAR_USUARIO";
		Usuario usuarioLogado;
		TypedQuery<Usuario> query = em.createNamedQuery(nomeSql, Usuario.class);
		query.setParameter("email", usuarioLogin.getEmail());
		query.setParameter("senha", usuarioLogin.getSenha());
		return query.getSingleResult();
	}

	public Usuario buscarUsuario(Long id) {

		String nomeSql = "CONSULTAR_USUARIO_POR_ID";
		Usuario usuario;
		TypedQuery<Usuario> query = em.createNamedQuery(nomeSql, Usuario.class);
		query.setParameter("id", id);
		usuario = query.getSingleResult();
		return usuario;
	}

	public void incluirUsuario(Usuario novoUsuario) {

		Usuario.persist(novoUsuario);
	}
}
