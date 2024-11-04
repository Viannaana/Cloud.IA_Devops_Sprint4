package br.com.NTJ.tech.dto.autenticacao;

import jakarta.validation.constraints.NotBlank;

public record DadosLogin(

        @NotBlank
        String login,
        @NotBlank
        String senha
) {
}
