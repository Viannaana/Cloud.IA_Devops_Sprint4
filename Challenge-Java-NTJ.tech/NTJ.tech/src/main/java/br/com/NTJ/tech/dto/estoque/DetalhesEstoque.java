package br.com.NTJ.tech.dto.estoque;

import br.com.NTJ.tech.model.estoque.Estoque;
import java.time.LocalDate;

public record DetalhesEstoque(Long codigo, LocalDate dtEstoque, Long qtProduto) {

    public DetalhesEstoque (Estoque estoque){
        this(estoque.getCodigo(), estoque.getDtEstoque(), estoque.getQtProduto());
    }
}
