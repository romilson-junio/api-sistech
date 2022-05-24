package br.com.sistech.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.json.bind.annotation.JsonbDateFormat;

import br.com.sistech.model.Cliente;
import br.com.sistech.model.ItensPedido;
import br.com.sistech.model.Usuario;

public class PedidoDto {
	
    private Long codigo;
    private UsuarioDto vendedor;
    private Double valorTotal;
    private ClienteDto cliente;
    @JsonbDateFormat("dd-MM-yyyy")
    private Date data = new Date();
    private List<ItensPedido> produtos = new ArrayList<>();
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public UsuarioDto getVendedor() {
		return vendedor;
	}
	public void setVendedor(UsuarioDto vendedor) {
		this.vendedor = vendedor;
	}

	public Double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public ClienteDto getCliente() {
		return cliente;
	}

	public void setCliente(ClienteDto cliente) {
		this.cliente = cliente;
	}

	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public List<ItensPedido> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<ItensPedido> produtos) {
		this.produtos = produtos;
	}
    
    
    
}
