package br.com.NTJ.tech.model.historicoPedido;


import br.com.NTJ.tech.dto.historicoPedido.CadastroHistoricoPedido;
import br.com.NTJ.tech.model.pedido.Pedido;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "TB_HISTORICO")
@EntityListeners(AuditingEntityListener.class)
public class HistoricoPedido {

    @Id
    @GeneratedValue
    @Column(name = "ID_HISTORICO")
    private Long codigo;

    @Column(name = "DT_HISTORICO", nullable = false)
    private LocalDate dtHistorico;

    @Column(name = "NM_PRODUTO", length = 100, nullable = false)
    private String produto;

    @Column(name = "DT_PEDIDO", nullable = false)
    private LocalDate dtPedido;

    @ManyToOne
    @JoinColumn(name = "ID_PEDIDO")
    private Pedido pedido;

    public HistoricoPedido(CadastroHistoricoPedido historicoPedido){
        dtHistorico = historicoPedido.dtHistorico();
        produto = historicoPedido.produto();
        dtPedido = historicoPedido.dtPedido();
    }

    public HistoricoPedido(CadastroHistoricoPedido historicoPedido, Pedido pedido){
        dtHistorico = historicoPedido.dtHistorico();
        produto = historicoPedido.produto();
        dtPedido = historicoPedido.dtPedido();
        this.pedido = pedido;
    }

    public void atualizarDados(CadastroHistoricoPedido atualizacao){
        if(atualizacao.dtHistorico() != null)
            dtHistorico = atualizacao.dtHistorico();
        if(atualizacao.produto() != null)
            produto = atualizacao.produto();
        if(atualizacao.dtPedido() != null)
            dtPedido = atualizacao.dtPedido();
    }
}
