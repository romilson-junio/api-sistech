package br.com.sistech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name = "produto")
public class Produto extends PanacheEntityBase{
	@Id
 	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
	
	@Column(name = "produto")
    private String produto;
	
    @Column(name = "quantidade")
    private Integer quantidade;

    @Column(name = "valor")
    private Double valor;
    
    @Column(name = "margen_lucro")
    private Double margenLucro;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Double getMargenLucro() {
		return margenLucro;
	}

	public void setMargenLucro(Double margenLucro) {
		this.margenLucro = margenLucro;
	}
	
}
