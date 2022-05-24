package br.com.sistech.service;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.sistech.dao.UsuarioDao;
import br.com.sistech.dto.ClienteDto;
import br.com.sistech.dto.PedidoDto;
import br.com.sistech.dto.UsuarioDto;
import br.com.sistech.dto.request.UsuarioRequest;
import br.com.sistech.model.Usuario;
import br.com.sistech.model.parser.UsuarioParser;
import br.com.sistech.utils.Sort;


@RequestScoped
public class UsuarioSevice {
	@Inject
    UsuarioDao dao;
    

    public List<UsuarioDto> listarUsuarios(){
        return dao.listarUsuarios().stream().map(UsuarioParser.get()::dto).collect(Collectors.toList());
    }


	public UsuarioDto buscarUsuario(UsuarioRequest usuarioLogin) {
		// TODO Auto-generated method stub
		Usuario usuarioLogado = dao.buscarUsuario(usuarioLogin);
		
		return UsuarioParser.get().dto(usuarioLogado);
	}

	public Usuario buscarUsuario(Long id) {
		// TODO Auto-generated method stub
		return dao.buscarUsuario(id);
	}

	@Transactional(rollbackOn = Exception.class)
	public void incluiUsuario(UsuarioDto novoUsuario) {
		// TODO Auto-generated method stub
		
		dao.incluirUsuario(UsuarioParser.get().entidade(novoUsuario));
	}


	public HashMap<String, Double> listarMelhoresVendedores(){
		HashMap<String, Double> dados = new HashMap<>();
		HashMap<String, Double> dadosOrdenados = new HashMap<>();
		List<UsuarioDto> vendedores = listarUsuarios();

		for (UsuarioDto vendedor: vendedores) {
			Double valor = 0D;
			for (PedidoDto pedido: vendedor.getPedidos()) {
				valor += pedido.getValorTotal();
			}
			if(valor.compareTo(0D)!=0) {
				dados.put(vendedor.getNome(), valor);
			}
		}
		dadosOrdenados = Sort.sortByValue(dados);
		return dadosOrdenados;
	}
	
}
