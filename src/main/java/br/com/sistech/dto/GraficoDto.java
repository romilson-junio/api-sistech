package br.com.sistech.dto;

import java.util.ArrayList;
import java.util.List;

public class GraficoDto {

    private List<String> descricoes = new ArrayList<>();
    private List<String> valores = new ArrayList<>();

    public List<String> getDescricoes() {
        return descricoes;
    }

    public List<String> getValores() {
        return valores;
    }
}
