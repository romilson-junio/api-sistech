package br.com.sistech.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.sistech.dao.PedidoDao;
import br.com.sistech.dao.UsuarioDao;
import br.com.sistech.dto.PedidoDto;
import br.com.sistech.dto.UsuarioDto;
import br.com.sistech.model.Usuario;
import br.com.sistech.model.parser.PedidoParser;
import br.com.sistech.model.parser.UsuarioParser;


@RequestScoped
public class PedidoService {
	@Inject
    PedidoDao dao;
    

    public List<PedidoDto> listarPedidos(){
        return dao.listarPedidos().stream().map(PedidoParser.get()::dto).collect(Collectors.toList());
    }

    @Transactional(rollbackOn = Exception.class)
	public PedidoDto incluirPedido(PedidoDto pedido) {
		// TODO Auto-generated method stub
		dao.incluirPedido(PedidoParser.get().entidade(pedido));
		return null;
	}

    /*
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

	*/
}
