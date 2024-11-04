package br.com.NTJ.tech.dto.pedido;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
@Schema(description = "Informações para cadastro de pedido")
public record CadastroPedido(
        @NotNull
        LocalDate dtPedido,
        @NotNull
        LocalDate dtCancelamento,
        @NotNull
        LocalDate dtEntrega,
        Integer vlPedido,
        Integer vlDesconto,
        @NotBlank
        @Schema(description = "Tipo de pedido")
        String tpPedido) {
}
