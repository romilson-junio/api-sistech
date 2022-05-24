package br.com.sistech.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.checkerframework.common.aliasing.qual.Unique;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cliente")
@NamedNativeQueries({
	@NamedNativeQuery(name="INSERIR_CLIENTE",
			  query = "INSERT INTO cliente (nome, email, cpf) values (:nome, :email, :cpf)"),
	@NamedNativeQuery(name="CONSULTAR_CLIENTE",
	  query = "SELECT id, nome, email, cpf FROM cliente where cpf = :cpf",
	  resultClass = Cliente.class)

})
public class Cliente extends PanacheEntityBase{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "email", unique = true)
	private String email;

	@Column(name = "cpf", unique = true)
	@CPF(message = "CPF inválido")
	private String cpf;

	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
	private List<Pedido> pedidos = new ArrayList<>();

	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
	private List<Endereco> enderecos = new ArrayList<>();

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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
}
