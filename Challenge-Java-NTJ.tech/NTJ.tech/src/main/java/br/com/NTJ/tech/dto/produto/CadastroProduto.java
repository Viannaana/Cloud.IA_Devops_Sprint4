package br.com.NTJ.tech.dto.produto;

import br.com.NTJ.tech.model.produto.*;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Schema(description = "Informações para cadastro de produto")
public record CadastroProduto(
        @NotBlank
        @Size(max = 100)
        @Schema(description = "Nome do produto")
        String nmProduto,
        @Size(max = 100)
        String barra,

        TipoStatus status,
        @NotNull
        LocalDate dataCadastro,
        @NotNull
        LocalDate dataCancelamento,
        TipoMarca marca,
        TipoCor cor,
        TipoTecido tecido,
        TipoTamanho tamanho
) {
}
