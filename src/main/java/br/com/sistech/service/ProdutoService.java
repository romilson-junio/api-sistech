package br.com.sistech.service;

import java.util.ArrayList;
import java.util.HashMap;
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
import br.com.sistech.model.ItensPedido;
import br.com.sistech.model.Produto;
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

    public ProdutoDto consultarProduto(String produto){
        return ProdutoParser.get().dto(dao.consultarProduto(produto));
    }


    @Transactional(rollbackOn = Exception.class)
	public ProdutoDto incluirProduto(ProdutoDto produto) {
		// TODO Auto-generated method stub
		dao.incluirProduto(ProdutoParser.get().entidade(produto));
		return null;
	}

    public HashMap<String, Integer> produtosMaisVendidos(){
        HashMap<String, Integer> produtos = new HashMap<>();

        List<Produto> pro = dao.listarProdutos();
        pro.stream().forEach(p -> {
            produtos.put(p.getProduto(), 0);
        });

        List<ItensPedido> produtosPedido =  dao.consultarItensVendidos();
        produtosPedido.stream().forEach(itensPedido -> {
            produtos.merge(itensPedido.getProduto(), itensPedido.getQuantidade(), Integer::sum);
        });
        return produtos;
    }

}
