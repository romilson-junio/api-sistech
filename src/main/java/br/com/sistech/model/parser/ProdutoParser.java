package br.com.sistech.model.parser;

import br.com.sistech.dto.ProdutoDto;
import br.com.sistech.model.Produto;

public class ProdutoParser {
	public static ProdutoParser get(){
        return  new ProdutoParser();
    }

    public ProdutoDto dto(Produto entidade){
    	ProdutoDto dto = new ProdutoDto();
    	
    	dto.setCodigo(entidade.getCodigo());
    	dto.setProduto(entidade.getProduto());
    	dto.setQuantidade(entidade.getQuantidade());
    	dto.setValor(entidade.getValor());
        return dto;
    }
    public Produto entidade(ProdutoDto dto){
    	Produto entidade = new Produto();
    	
    	entidade.setProduto(dto.getProduto());
    	entidade.setQuantidade(dto.getQuantidade());
    	entidade.setValor(dto.getValor());
        return entidade;
    }
}
