package br.com.NTJ.tech.dto.MovimentoEstoque;

import br.com.NTJ.tech.model.movimentoEstoque.MovimentoEstoque;
import java.time.LocalDate;

public record DetalhesMovimentoEstoque(Long codigo, LocalDate data, Long quantidade) {

    public DetalhesMovimentoEstoque(MovimentoEstoque movimentoEstoque){
        this(movimentoEstoque.getCodigo(), movimentoEstoque.getData(),
                movimentoEstoque.getQuantidade());
    }
}
