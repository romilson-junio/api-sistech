package br.com.sistech.model.parser;

import br.com.sistech.dto.EnderecoDto;
import br.com.sistech.model.Endereco;

public class EnderecoParser {
	public static EnderecoParser get(){
        return  new EnderecoParser();
    }

    public EnderecoDto dto(Endereco entidade){
        EnderecoDto dto = new EnderecoDto();
        dto.setId(entidade.getId());
        dto.setCep(entidade.getCep());
        dto.setEstado(entidade.getEstado());
        dto.setCidade(entidade.getCidade());
        dto.setComplemento(entidade.getComplemento());
        dto.setRua(entidade.getRua());
        return dto;
    }

    public Endereco entidade(EnderecoDto dto){
        Endereco entidade = new Endereco();
        entidade.setId(dto.getId());
        entidade.setCep(dto.getCep());
        entidade.setCidade(dto.getCidade());
        entidade.setEstado(dto.getEstado());
        entidade.setRua(dto.getRua());
        entidade.setComplemento(dto.getComplemento());
        return entidade;
    }
}
