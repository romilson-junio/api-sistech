package br.com.sistech.model.parser;

import br.com.sistech.dto.ClienteDto;
import br.com.sistech.model.Cliente;

import java.util.stream.Collectors;

public class ClienteParser {
	public static ClienteParser get(){
        return  new ClienteParser();
    }

    public ClienteDto dto(Cliente entidade){
    	ClienteDto dto = new ClienteDto();

        dto.setId(entidade.getId());
        dto.setEmail(entidade.getEmail());
        dto.setNome(entidade.getNome());
        dto.setCpf(entidade.getCpf());
        dto.getPedidos().addAll(entidade.getPedidos().stream().map(PedidoParser.get()::dto).collect(Collectors.toList()));
        dto.getEnderecos().addAll(entidade.getEnderecos().stream().map(EnderecoParser.get()::dto).collect(Collectors.toList()));
        return dto;
    }
    public ClienteDto dtoPedido(Cliente entidade){
        ClienteDto dto = new ClienteDto();

        dto.setId(entidade.getId());
        dto.setEmail(entidade.getEmail());
        dto.setNome(entidade.getNome());
        dto.setCpf(entidade.getCpf());
        return dto;
    }

    public Cliente entidade(ClienteDto dto){
    	Cliente entidade = new Cliente();

    	entidade.setEmail(dto.getEmail());
    	entidade.setNome(dto.getNome());
    	entidade.setCpf(dto.getCpf());
        return entidade;
    }
}
