package br.com.sistech.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
@Entity
@Table(name = "pedido")

@NamedNativeQueries({
	@NamedNativeQuery(name="PEDIDO_POR_CLIENTE",
	  query = "SELECT * FROM pedido where cliente.cpf = :cpf",
	  resultClass = Pedido.class)
})

public class Pedido extends PanacheEntityBase{
	@Id
 	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(name = "valor_total")
    private Double valorTotal;

	@ManyToOne
	@JoinColumn(name = "client_id")
	private Cliente cliente;

	@ManyToOne
	@JoinColumn(name = "vendedor_id")
	private Usuario vendedor;

    @Column(name = "data")
    private Date data;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
        )
    private List<ItensPedido> produtos = new ArrayList<>();

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Usuario getVendedor() {
		return vendedor;
	}

	public void setVendedor(Usuario vendedor) {
		this.vendedor = vendedor;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public List<ItensPedido> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<ItensPedido> produtos) {
		this.produtos = produtos;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
