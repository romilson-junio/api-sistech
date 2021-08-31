package br.com.sistech.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
@Entity
@Table(name = "pedido")
/*
@NamedNativeQueries({
	@NamedNativeQuery(name="INSERIR_USUARIO", 
			  query = "INSERT INTO usuario (nome, email, senha, perfil) values (:nome, :email, :senha, :perfil)"),
	@NamedNativeQuery(name="CONSULTAR_USUARIO", 
	  query = "SELECT id, nome, email, senha, perfil FROM usuario where email = :email and senha = :senha", 
	  resultClass = Pedido.class)

})
*/
public class Pedido extends PanacheEntityBase{
	@Id
 	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

	@Column(name = "vendedor")
    private String vendedor;
	
    @Column(name = "valor_total")
    private Double valorTotal;

    @Column(name = "cpf_cliente")
    private String cpfCliente;
    
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


    
    
}
