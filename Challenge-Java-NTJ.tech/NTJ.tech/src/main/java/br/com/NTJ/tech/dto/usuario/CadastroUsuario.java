package br.com.NTJ.tech.dto.usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CadastroUsuario(

        @NotBlank
        @Size(max = 25)
        String username,

        @NotBlank
        String password) {
}
