package br.com.sistech.model.parser;

import br.com.sistech.dto.UsuarioDto;
import br.com.sistech.model.Usuario;

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
        dto.setSenha(entidade.getSenha());
        return dto;
    }
    public Usuario entidade(UsuarioDto dto){
    	Usuario entidade = new Usuario();

    	entidade.setEmail(dto.getEmail());
    	entidade.setNome(dto.getNome());
    	entidade.setPerfil(dto.getPerfil());
    	entidade.setSenha(dto.getSenha());
        return entidade;
    }
}
