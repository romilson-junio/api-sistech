package br.com.sistech.model.parser;

import br.com.sistech.dto.PedidoDto;
import br.com.sistech.dto.request.PedidoRequest;
import br.com.sistech.model.Pedido;

import java.util.stream.Collectors;

public class PedidoParser {
	public static PedidoParser get(){
        return  new PedidoParser();
    }

    public PedidoDto dto(Pedido entidade){
    	PedidoDto dto = new PedidoDto();
    	
    	dto.setCodigo(entidade.getCodigo());
    	dto.setVendedor(UsuarioParser.get().dtoPedido(entidade.getVendedor()));
		dto.setCliente(ClienteParser.get().dtoPedido(entidade.getCliente()));
    	dto.setValorTotal(entidade.getValorTotal());
    	dto.setData(entidade.getData());
    	dto.setProdutos(entidade.getProdutos());
      
        return dto;
    }
    public Pedido entidade(PedidoDto dto){
    	Pedido entidade = new Pedido();
    	
    	entidade.setVendedor(UsuarioParser.get().entidade(dto.getVendedor()));
    	entidade.setValorTotal(dto.getValorTotal());
    	entidade.setData(dto.getData());
    	entidade.setProdutos(dto.getProdutos());
    	
        return entidade;
    }

	public Pedido entidade(PedidoRequest pedidoRequest) {
		Pedido entidade = new Pedido();

		entidade.setData(pedidoRequest.getData());
		entidade.setProdutos(pedidoRequest.getProdutos().stream().map(ItensPedidoParser.get()::entidade).collect(Collectors.toList()));
		entidade.setValorTotal(pedidoRequest.getValorTotal());
		return entidade;
	}
}
