package br.com.sistech.model;

import javax.persistence.*;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name = "produto")
@NamedNativeQueries({
		@NamedNativeQuery(name="CONSULTAR_PRODUTO",
				query = "SELECT * FROM produto where produto = :produto",
				resultClass = Produto.class)

})
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
	
}
