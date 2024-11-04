package br.com.NTJ.tech.dto.produto;

import br.com.NTJ.tech.dto.pedido.DetalhesPedido;
import br.com.NTJ.tech.model.produto.*;

import java.time.LocalDate;

public record DetalhesProdutoPedido(Long codigo, String nmProduto, String barra,
                                    TipoStatus status, LocalDate dataCadastro, LocalDate dataCancelamento,
                                    TipoMarca marca, TipoCor cor, TipoTecido tecido, TipoTamanho tamanho,
                                    DetalhesPedido pedido) {

    public DetalhesProdutoPedido(Produto produto){
        this(produto.getCodigo(), produto.getNmProduto(), produto.getBarra(), produto.getStatus(),
                produto.getDataCadastro(), produto.getDataCancelamento(), produto.getMarca(), produto.getCor(),
                produto.getTecido(), produto.getTamanho(), new DetalhesPedido(produto.getPedido()));
    }
}
