package br.com.sistech.service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.sistech.dao.PedidoDao;
import br.com.sistech.dto.PedidoDto;
import br.com.sistech.dto.request.PedidoRequest;
import br.com.sistech.model.Cliente;
import br.com.sistech.model.Pedido;
import br.com.sistech.model.Usuario;
import br.com.sistech.model.parser.PedidoParser;


@RequestScoped
public class PedidoService {

    @Inject
    PedidoDao dao;

    @Inject
    ClienteSevice clienteSevice;

    @Inject
    UsuarioSevice usuarioSevice;

    public List<PedidoDto> listarPedidos(){
        List<Pedido> pedidos = dao.listarPedidos();
        return pedidos.stream().map(PedidoParser.get()::dto).collect(Collectors.toList());
    }

    @Transactional(rollbackOn = Exception.class)
	public void incluirPedido(PedidoRequest pedidoRequest) throws Exception {
		// TODO Auto-generated method stub

        if(Objects.isNull(pedidoRequest.getCliente())){
            throw new Exception();
        }
        if(Objects.isNull(pedidoRequest.getVendedor())){
            throw new Exception();
        }
        Cliente cliente = clienteSevice.buscarCliente(pedidoRequest.getCliente());
        if(Objects.isNull(cliente)){
            throw new Exception();
        }
        Usuario vendedor = usuarioSevice.buscarUsuario(pedidoRequest.getVendedor());
        if(Objects.isNull(vendedor)){
            throw new Exception();
        }

        Pedido pedido = PedidoParser.get().entidade(pedidoRequest);
        pedido.setVendedor(vendedor);
        pedido.setCliente(cliente);
        dao.incluirPedido(pedido);
	}

    public List<PedidoDto> pedidoPorCliente(String cpf){
        return dao.pedidosPorCliente(cpf).stream().map(PedidoParser.get()::dto).collect(Collectors.toList());
    }


}
