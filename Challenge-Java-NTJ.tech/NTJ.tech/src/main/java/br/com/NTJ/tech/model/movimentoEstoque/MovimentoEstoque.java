package br.com.NTJ.tech.model.movimentoEstoque;

import br.com.NTJ.tech.dto.MovimentoEstoque.CadastroMovimentoEstoque;
import br.com.NTJ.tech.model.produto.Produto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "TB_MOVIMENTO")
public class MovimentoEstoque {

    @Id
    @GeneratedValue
    @Column(name = "ID_MOVIMENTO")
    private Long codigo;

    @Column(name = "DT_MOVIMENTO", nullable = false)
    private LocalDate data;

    @Column(name = "QT_MOVIMENTO", length = 100, nullable = true)
    private Long quantidade;

    @ManyToOne
    @JoinColumn(name = "ID_PRODUTO")
    private Produto produto;

    public MovimentoEstoque(CadastroMovimentoEstoque movimentoEstoque){
        data = movimentoEstoque.data();
        quantidade = movimentoEstoque.quantidade();
    }

    public MovimentoEstoque(CadastroMovimentoEstoque movimentoEstoque, Produto produto){
        data = movimentoEstoque.data();
        quantidade = movimentoEstoque.quantidade();
        this.produto = produto;
    }

    public void atualizarDados(CadastroMovimentoEstoque atualizacao){
        if(atualizacao.data() != null)
            data = atualizacao.data();
        if(atualizacao.quantidade() != null)
            quantidade = atualizacao.quantidade();
    }
}
