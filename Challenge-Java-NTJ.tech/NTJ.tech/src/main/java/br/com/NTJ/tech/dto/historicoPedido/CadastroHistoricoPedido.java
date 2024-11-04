package br.com.NTJ.tech.dto.historicoPedido;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Schema(description = "Informações para cadastro historico de pedido")
public record CadastroHistoricoPedido(
        @NotNull
        LocalDate dtHistorico,
        @NotBlank
        @Size(max = 100)
        @Schema(description = "Produto do historico de pedido")
        String produto,
        @NotNull
        LocalDate dtPedido) {
}
