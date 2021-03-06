package br.com.sistech.dto;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDto {

	private Long id;
    private String email;
    private String nome;
    private String senha;
    private String perfil;
	private List<PedidoDto> pedidos = new ArrayList<>();

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

	public List<PedidoDto> getPedidos() {
		return pedidos;
	}
}
