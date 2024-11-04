package br.com.NTJ.tech.dto.categoria;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Schema(description = "Informações para cadastro de categoria")
public record CadastroCategoria(
        @NotBlank
        @Size(max = 100)
        @Schema(description = "Nome da categoria")
        String nome,

        @NotBlank
        @Size(max = 200)
        @Schema(description = "Descrição da categoria")
        String descricao) {
}
