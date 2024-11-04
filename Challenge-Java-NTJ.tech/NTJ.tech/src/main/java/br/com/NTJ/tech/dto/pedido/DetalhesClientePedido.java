package br.com.NTJ.tech.dto.pedido;

import br.com.NTJ.tech.dto.cliente.DetalhesCliente;
import br.com.NTJ.tech.model.pedido.Pedido;

import java.time.LocalDate;

public record DetalhesClientePedido(Long Codigo, LocalDate dtPedido, LocalDate dtCancelamento,
                                    LocalDate dtEntrega, Integer vlPedido, Integer vlDesconto, String tpPedido,
                                    DetalhesCliente cliente) {

    public DetalhesClientePedido(Pedido pedido){
        this(pedido.getCodigo(), pedido.getDtPedido(), pedido.getDtCancelamento(), pedido.getDtEntrega(), pedido.getVlPedido(),
                pedido.getVlDesconto(), pedido.getTpPedido(), new DetalhesCliente(pedido.getCliente()));
    }
}
