package br.com.sistech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name = "usuario")
@NamedNativeQueries({
	@NamedNativeQuery(name="INSERIR_USUARIO", 
			  query = "INSERT INTO usuario (nome, email, senha, perfil) values (:nome, :email, :senha, :perfil)"),
	@NamedNativeQuery(name="CONSULTAR_USUARIO", 
	  query = "SELECT id, nome, email, senha, perfil FROM usuario where email = :email and senha = :senha", 
	  resultClass = Usuario.class)

})
public class Usuario extends PanacheEntityBase{

		@Id
	 	@GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

		@Column(name = "nome")
	    private String nome;
		
	    @Column(name = "email")
	    private String email;

	    @Column(name = "senha")
	    private String senha;

	    @Column(name = "perfil")
	    private String perfil;

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
	    
	    
	    
}
