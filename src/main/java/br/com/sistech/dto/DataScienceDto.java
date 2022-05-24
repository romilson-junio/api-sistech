package br.com.sistech.dto;

public class DataScienceDto {

    private GraficoDto graficoCliente = new GraficoDto();
    private GraficoDto graficoVendedor = new GraficoDto();
    private GraficoDto graficoVendas = new GraficoDto();
    private GraficoDto graficoProdutos = new GraficoDto();

    public GraficoDto getGraficoCliente() {
        return graficoCliente;
    }

    public GraficoDto getGraficoVendedor() {
        return graficoVendedor;
    }

    public GraficoDto getGraficoVendas() {
        return graficoVendas;
    }

    public GraficoDto getGraficoProdutos() {
        return graficoProdutos;
    }
}
