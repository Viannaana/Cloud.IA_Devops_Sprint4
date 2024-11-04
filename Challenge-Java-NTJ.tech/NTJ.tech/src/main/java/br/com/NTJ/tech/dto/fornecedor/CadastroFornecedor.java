package br.com.NTJ.tech.dto.fornecedor;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Schema(description = "Informações para cadastro de fornecedor")
public record CadastroFornecedor(
        Long id,

        @NotBlank
        @Size(max = 100)
        @Schema(description = "Nome do fornecedor")
        String nome,

        @NotBlank
        @Size(max = 50)
        @Schema(description = "Telefone do fornecedor")
        String telefone,

        @NotBlank
        @Size(max = 100)
        @Schema(description = "E-mail do fornecedor")
        String email) {
}
