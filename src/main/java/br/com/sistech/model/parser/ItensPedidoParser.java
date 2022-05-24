package br.com.sistech.model.parser;

import br.com.sistech.dto.PedidoDto;
import br.com.sistech.dto.request.ItensPedidoRequest;
import br.com.sistech.dto.request.PedidoRequest;
import br.com.sistech.model.ItensPedido;
import br.com.sistech.model.Pedido;

public class ItensPedidoParser {
	public static ItensPedidoParser get(){
        return  new ItensPedidoParser();
    }

    public ItensPedidoRequest dto(ItensPedido entidade){
    	ItensPedidoRequest produtos = new ItensPedidoRequest();

		produtos.setIdProduto(entidade.getIdProduto());
		produtos.setProduto(entidade.getProduto());
		produtos.setValor(entidade.getValor());
		produtos.setQuantidade(entidade.getQuantidade());
		produtos.setValorTotal(entidade.getValorTotal());

        return produtos;
    }
    public ItensPedido entidade(ItensPedidoRequest dto){
		ItensPedido entidade = new ItensPedido();
		entidade.setIdProduto(dto.getIdProduto());
		entidade.setProduto(dto.getProduto());
		entidade.setValor(dto.getValor());
		entidade.setQuantidade(dto.getQuantidade());
		entidade.setValorTotal(dto.getValorTotal());
        return entidade;
    }
}
