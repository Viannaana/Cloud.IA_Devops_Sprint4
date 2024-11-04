package br.com.NTJ.tech.model.estoque;

import br.com.NTJ.tech.dto.estoque.CadastroEstoque;
import br.com.NTJ.tech.dto.pedido.CadastroPedido;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "TB_ESTOQUE")
public class Estoque {

    @Id
    @GeneratedValue
    @Column(name = "ID_ESTOQUE")
    private Long codigo;

    @Column(name = "DT_ESTOQUE", nullable = true)
    private LocalDate dtEstoque;

    @Column(name = "QT_PRODUTO", nullable = false)
    private Long qtProduto;

    public Estoque(CadastroEstoque estoque) {
        dtEstoque = estoque.dtEstoque();
        qtProduto = estoque.qtProduto();
    }

    public void atualizarDados(CadastroEstoque atualizacao) {
        if (atualizacao.dtEstoque() != null)
            dtEstoque = atualizacao.dtEstoque();
        if (atualizacao.qtProduto() != null)
            qtProduto = atualizacao.qtProduto();
    }
}
