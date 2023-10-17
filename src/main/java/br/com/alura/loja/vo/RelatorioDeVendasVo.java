package br.com.alura.loja.vo;

import java.time.LocalDate;

public record RelatorioDeVendasVo(String nomeDoProduto, Long quantidadeVendida, LocalDate dataUltimaVenda) {
}
