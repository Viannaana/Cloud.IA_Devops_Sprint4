package br.com.NTJ.tech.dto.historicoPedido;

import br.com.NTJ.tech.model.historicoPedido.HistoricoPedido;
import java.time.LocalDate;

public record DetalhesHistoricoPedido(Long codigo, LocalDate dtHistorico, String produto, LocalDate dtPedido) {

    public DetalhesHistoricoPedido(HistoricoPedido historicoPedido){
        this(historicoPedido.getCodigo(), historicoPedido.getDtHistorico(), historicoPedido.getProduto(),
        historicoPedido.getDtPedido());
    }
}
