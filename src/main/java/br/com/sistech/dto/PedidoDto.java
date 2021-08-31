package br.com.sistech.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.json.bind.annotation.JsonbDateFormat;

import br.com.sistech.model.ItensPedido;

public class PedidoDto {
	
    private Long codigo;
    private String vendedor;
    private Double valorTotal;
    private String cpfCliente;
    @JsonbDateFormat("dd-MM-yyyy")
    private Date data = new Date();
    private List<ItensPedido> produtos = new ArrayList<>();
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getVendedor() {
		return vendedor;
	}
	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}

	public Double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public String getCpfCliente() {
		return cpfCliente;
	}
	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
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
