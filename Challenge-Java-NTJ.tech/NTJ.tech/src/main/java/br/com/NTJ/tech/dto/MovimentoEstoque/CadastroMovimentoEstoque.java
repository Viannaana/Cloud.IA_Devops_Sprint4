package br.com.NTJ.tech.dto.MovimentoEstoque;


import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record CadastroMovimentoEstoque(

        @NotNull
        LocalDate data,
        Long quantidade) {
}
