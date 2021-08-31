package br.com.sistech.model.parser;

import br.com.sistech.dto.PedidoDto;
import br.com.sistech.dto.UsuarioDto;
import br.com.sistech.model.Pedido;
import br.com.sistech.model.Usuario;

public class PedidoParser {
	public static PedidoParser get(){
        return  new PedidoParser();
    }

    public PedidoDto dto(Pedido entidade){
    	PedidoDto dto = new PedidoDto();
    	
    	dto.setCodigo(entidade.getCodigo());
    	dto.setVendedor(entidade.getVendedor());
    	dto.setCpfCliente(entidade.getCpfCliente());
    	dto.setValorTotal(entidade.getValorTotal());
    	dto.setData(entidade.getData());
    	dto.setProdutos(entidade.getProdutos());
      
        return dto;
    }
    public Pedido entidade(PedidoDto dto){
    	Pedido entidade = new Pedido();
    	
    	entidade.setVendedor(dto.getVendedor());
    	entidade.setCpfCliente(dto.getCpfCliente());
    	entidade.setValorTotal(dto.getValorTotal());
    	entidade.setData(dto.getData());
    	entidade.setProdutos(dto.getProdutos());
    	
        return entidade;
    }
}
