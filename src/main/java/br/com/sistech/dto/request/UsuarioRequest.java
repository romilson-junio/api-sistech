package br.com.sistech.dto.request;

import br.com.sistech.dto.PedidoDto;

import java.util.ArrayList;
import java.util.List;

public class UsuarioRequest {

    private String email;
    private String senha;

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

}
