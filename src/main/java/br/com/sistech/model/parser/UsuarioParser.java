package br.com.sistech.model.parser;

import br.com.sistech.dto.UsuarioDto;
import br.com.sistech.model.Usuario;

import java.util.stream.Collectors;

public class UsuarioParser {
	public static UsuarioParser get(){
        return  new UsuarioParser();
    }

    public UsuarioDto dto(Usuario entidade){
    	UsuarioDto dto = new UsuarioDto();

        dto.setId(entidade.getId());
        dto.setEmail(entidade.getEmail());
        dto.setNome(entidade.getNome());
        dto.setPerfil(entidade.getPerfil());
        dto.getPedidos().addAll(entidade.getPedidos().stream().map(PedidoParser.get()::dto).collect(Collectors.toList()));
        return dto;
    }
    public UsuarioDto dtoPedido(Usuario entidade){
        UsuarioDto dto = new UsuarioDto();

        dto.setId(entidade.getId());
        dto.setEmail(entidade.getEmail());
        dto.setNome(entidade.getNome());
        dto.setPerfil(entidade.getPerfil());
        return dto;
    }

    public Usuario entidade(UsuarioDto dto){
    	Usuario entidade = new Usuario();

        entidade.setId(dto.getId());
    	entidade.setEmail(dto.getEmail());
    	entidade.setNome(dto.getNome());
    	entidade.setPerfil(dto.getPerfil());
    	entidade.setSenha(dto.getSenha());
        return entidade;
    }
}
