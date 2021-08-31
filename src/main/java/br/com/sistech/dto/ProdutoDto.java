package br.com.sistech.dto;


public class ProdutoDto {
    private Long codigo;
    private String produto;
    private Integer quantidade;
    private Double valor;
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
