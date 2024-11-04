package br.com.NTJ.tech.dto.MovimentoEstoque;

import br.com.NTJ.tech.dto.produto.DetalhesProduto;
import br.com.NTJ.tech.model.movimentoEstoque.MovimentoEstoque;

import java.time.LocalDate;

public record DetalhesProdutoMovimento(Long codigo, LocalDate data, Long quantidade,
                                       DetalhesProduto produto) {

    public DetalhesProdutoMovimento(MovimentoEstoque movimentoEstoque){
        this(movimentoEstoque.getCodigo(), movimentoEstoque.getData(),
                movimentoEstoque.getQuantidade(), new DetalhesProduto(movimentoEstoque.getProduto()));
    }
}
