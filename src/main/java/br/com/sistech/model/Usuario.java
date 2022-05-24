package br.com.sistech.model;

import javax.persistence.*;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.checkerframework.common.aliasing.qual.Unique;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "usuario")
@NamedNativeQueries({
	@NamedNativeQuery(name="INSERIR_USUARIO", 
			query = "INSERT INTO usuario (nome, email, senha, perfil) values (:nome, :email, :senha, :perfil)"),
	@NamedNativeQuery(name="CONSULTAR_USUARIO", 
			query = "SELECT * FROM usuario where email = :email and senha = :senha",
			resultClass = Usuario.class),
	@NamedNativeQuery(name="CONSULTAR_USUARIO_POR_ID",
			query = "SELECT * FROM usuario where id = :id",
			resultClass = Usuario.class)
})
public class Usuario extends PanacheEntityBase{

		@Id
	 	@GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

		@Column(name = "nome")
	    private String nome;

	    @Column(name = "email", unique = true)
	    private String email;

	    @Column(name = "senha")
	    private String senha;

	    @Column(name = "perfil")
	    private String perfil;

		@OneToMany(mappedBy = "vendedor", cascade = CascadeType.ALL)
		private List<Pedido> pedidos = new ArrayList<>();

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		
		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getSenha() {
			return senha;
		}

		public void setSenha(String senha) {
			this.senha = senha;
		}

		public String getPerfil() {
			return perfil;
		}

		public void setPerfil(String perfil) {
			this.perfil = perfil;
		}

	public List<Pedido> getPedidos() {
		return pedidos;
	}
}
