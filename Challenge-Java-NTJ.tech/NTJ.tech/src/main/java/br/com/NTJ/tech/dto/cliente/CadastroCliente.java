package br.com.NTJ.tech.dto.cliente;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Schema(description = "Informações para cadastro do cliente")
public record CadastroCliente(

        @Size(max = 100)
        @Schema(description = "Nome do cliente")
        String nome,
        @Size(max = 100)
        @Schema(description = "E-mail do cliente")
        String email,
        @Size(max = 15)
        @Schema(description = "Telefone do cliente")
        String telefone,
        LocalDate cadastro,
        LocalDate cancelamento,
        @Size(max = 100)
        @Schema(description = "Status do cliente")
        String status) {
}
