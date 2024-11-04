package br.com.NTJ.tech.dto.historicoPedido;

import br.com.NTJ.tech.dto.pedido.DetalhesPedido;
import br.com.NTJ.tech.model.historicoPedido.HistoricoPedido;

import java.time.LocalDate;

public record DetalhesPedidoHistorico(Long codigo, LocalDate dtHistorico, String produto, LocalDate dtPedido,
                                      DetalhesPedido pedido) {

    public DetalhesPedidoHistorico(HistoricoPedido historicoPedido){
        this(historicoPedido.getCodigo(), historicoPedido.getDtHistorico(), historicoPedido.getProduto(),
                historicoPedido.getDtPedido(), new DetalhesPedido(historicoPedido.getPedido()));
    }
}
