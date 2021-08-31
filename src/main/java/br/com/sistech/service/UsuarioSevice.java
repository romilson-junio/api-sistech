package br.com.sistech.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.sistech.dao.UsuarioDao;
import br.com.sistech.dto.UsuarioDto;
import br.com.sistech.model.Usuario;
import br.com.sistech.model.parser.UsuarioParser;


@RequestScoped
public class UsuarioSevice {
	@Inject
    UsuarioDao dao;
    

    public List<UsuarioDto> listarUsuarios(){
        return dao.listarUsuarios().stream().map(UsuarioParser.get()::dto).collect(Collectors.toList());
    }


	public UsuarioDto buscarUsuario(UsuarioDto usuarioLogin) {
		// TODO Auto-generated method stub
		Usuario usuarioLogado = dao.buscarUsuario(usuarioLogin).get(0);
		
		return UsuarioParser.get().dto(usuarioLogado);
	}

	@Transactional(rollbackOn = Exception.class)
	public void incluiUsuario(UsuarioDto novoUsuario) {
		// TODO Auto-generated method stub
		
		dao.incluirUsuario(UsuarioParser.get().entidade(novoUsuario));
	}
    


	
}
