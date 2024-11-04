package br.com.NTJ.tech.dto.estoque;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record CadastroEstoque(
        Long codigo,

        @NotNull
        LocalDate dtEstoque,
        Long qtProduto) {
}
