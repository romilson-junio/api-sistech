package br.com.sistech.service;

import br.com.sistech.dto.ClienteDto;
import br.com.sistech.dto.DataScienceDto;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@RequestScoped
public class DataScienceSevice {
	@Inject
	UsuarioSevice usuarioSevice;

	@Inject
	ClienteSevice clienteSevice;

	@Inject
	PedidoService pedidoService;

	@Inject
	ProdutoService produtoService;

    public DataScienceDto gerarDadosGrafico(){
		DataScienceDto graficos = new DataScienceDto();

		HashMap<String, Double> clientes = clienteSevice.listarMelhoresClientes();
		clientes.forEach((key,value) -> {
			graficos.getGraficoCliente().getDescricoes().add(key);
			graficos.getGraficoCliente().getValores().add(String.valueOf(value));
		});

		HashMap<String, Double> vendedores = usuarioSevice.listarMelhoresVendedores();
		vendedores.forEach((key,value) -> {
			graficos.getGraficoVendedor().getDescricoes().add(key);
			graficos.getGraficoVendedor().getValores().add(String.valueOf(value));
		});

		graficos.getGraficoVendas().getDescricoes().addAll(Arrays.asList("Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"));
		graficos.getGraficoVendas().getValores().addAll(Arrays.asList("1000", "2000", "1500", "500", "10000", "100", "6000", "2000", "300", "1000", "1500", "7000"));


		HashMap<String, Integer> produtosVendidos = produtoService.produtosMaisVendidos();
		produtosVendidos.forEach((key,value) -> {
			if(value > 0){
				graficos.getGraficoProdutos().getDescricoes().add(key);
				graficos.getGraficoProdutos().getValores().add(String.valueOf(value));
			}
		});

		return graficos;
	}
}
