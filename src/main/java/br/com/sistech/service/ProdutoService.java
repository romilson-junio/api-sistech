package br.com.sistech.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.sistech.dao.PedidoDao;
import br.com.sistech.dao.ProdutoDao;
import br.com.sistech.dao.UsuarioDao;
import br.com.sistech.dto.PedidoDto;
import br.com.sistech.dto.ProdutoDto;
import br.com.sistech.dto.UsuarioDto;
import br.com.sistech.model.Usuario;
import br.com.sistech.model.parser.PedidoParser;
import br.com.sistech.model.parser.ProdutoParser;
import br.com.sistech.model.parser.UsuarioParser;


@RequestScoped
public class ProdutoService {
	@Inject
    ProdutoDao dao;
    

    public List<ProdutoDto> listarPedidos(){
        return dao.listarProdutos().stream().map(ProdutoParser.get()::dto).collect(Collectors.toList());
    }

    @Transactional(rollbackOn = Exception.class)
	public ProdutoDto incluirProduto(ProdutoDto produto) {
		// TODO Auto-generated method stub
		dao.incluirProduto(ProdutoParser.get().entidade(produto));
		return null;
	}

}
