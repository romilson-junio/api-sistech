package br.com.sistech.dto.request;

import br.com.sistech.model.ItensPedido;

import javax.json.bind.annotation.JsonbDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PedidoRequest {

    private Long vendedor;
    private Double valorTotal;
    private String cliente;
    @JsonbDateFormat("dd-MM-yyyy")
    private Date data = new Date();
    private List<ItensPedidoRequest> produtos = new ArrayList<>();

    public Long getVendedor() {
        return vendedor;
    }

    public void setVendedor(Long vendedor) {
        this.vendedor = vendedor;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public List<ItensPedidoRequest> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ItensPedidoRequest> produtos) {
        this.produtos = produtos;
    }
}
