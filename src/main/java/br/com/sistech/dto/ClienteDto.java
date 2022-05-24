package br.com.sistech.dto;

import java.util.ArrayList;
import java.util.List;

public class ClienteDto {

	private Long id;
    private String email;
    private String nome;
    private String cpf;
	private List<PedidoDto> pedidos = new ArrayList<>();
	private List<EnderecoDto> enderecos = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public List<PedidoDto> getPedidos() {
		return pedidos;
	}

	public List<EnderecoDto> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<EnderecoDto> enderecos) {
		this.enderecos = enderecos;
	}
}
