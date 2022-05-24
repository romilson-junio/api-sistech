package br.com.sistech.service;

import br.com.sistech.dao.ClienteDao;
import br.com.sistech.dto.ClienteDto;
import br.com.sistech.dto.PedidoDto;
import br.com.sistech.model.Cliente;
import br.com.sistech.model.parser.ClienteParser;
import br.com.sistech.utils.Sort;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;


@RequestScoped
public class ClienteSevice {
	@Inject
	ClienteDao dao;

	@Inject
    PedidoService pedidoService;

    public List<ClienteDto> listarClientes(){
        List<ClienteDto> clientes = dao.listarClientes().stream().map(ClienteParser.get()::dto).collect(Collectors.toList());
		return clientes;
    }


	public Cliente buscarCliente(String cpf) {
		// TODO Auto-generated method stub
		Cliente cliente = dao.buscarCliente(cpf).get(0);
		return cliente;
	}

	public ClienteDto buscarCliente(ClienteDto clienteDto) {
		// TODO Auto-generated method stub
		Cliente cliente = dao.buscarCliente(clienteDto.getCpf()).get(0);
		return ClienteParser.get().dto(cliente);
	}

	@Transactional(rollbackOn = Exception.class)
	public void incluirCliente(ClienteDto clienteDto) {
		// TODO Auto-generated method stub
		dao.incluirCliente(ClienteParser.get().entidade(clienteDto));
	}
    
	public HashMap<String, Double> listarMelhoresClientes(){
		HashMap<String, Double> dados = new HashMap<>();
		HashMap<String, Double> dadosOrdenados = new HashMap<>();
		List<ClienteDto> clientes = listarClientes();

		for (ClienteDto cliente: clientes) {
			Double valor = 0D;
			for (PedidoDto pedido: cliente.getPedidos()) {
				valor += pedido.getValorTotal();
			}
			if(valor.compareTo(0D)!=0) {
				dados.put(cliente.getNome(), valor);
			}
		}
		dadosOrdenados = Sort.sortByValue(dados);
		return dadosOrdenados;
	}


	
}
