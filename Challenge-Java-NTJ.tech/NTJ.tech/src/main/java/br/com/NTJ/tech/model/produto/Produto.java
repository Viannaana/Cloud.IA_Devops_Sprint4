package br.com.NTJ.tech.model.produto;

import br.com.NTJ.tech.dto.produto.CadastroProduto;
import br.com.NTJ.tech.model.categoria.Categoria;
import br.com.NTJ.tech.model.movimentoEstoque.MovimentoEstoque;
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
@Table(name = "TB_PRODUTO")
@EntityListeners(AuditingEntityListener.class)
public class Produto {

    @Id
    @GeneratedValue
    @Column(name = "ID_PRODUTO")
    private Long codigo;

    @Column(name = "NM_PRODUTO", length = 100, nullable = false)
    private String nmProduto;

    @Column(name = "CD_BARRA", length = 100, nullable = true)
    private String barra;

    @Column(name = "ST_ATIVO", length = 10, nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoStatus status;

    @Column(name = "DT_CADASTRO", nullable = false)
    private LocalDate dataCadastro;

    @Column(name = "DT_CANCELAMENTO", nullable = false)
    private LocalDate dataCancelamento;

    @Column(name = "TB_MARCA", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoMarca marca;

    @Column(name = "TB_COR", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoCor cor;

    @Column(name = "TB_TECIDO", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoTecido tecido;

    @Column(name = "TB_TAMANHO", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoTamanho tamanho;

    @ManyToOne
    @JoinColumn(name = "ID_PEDIDO")
    private Pedido pedido;

    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL)
    private List<MovimentoEstoque> movimentoEstoques;

    public Produto(CadastroProduto produto, MovimentoEstoque movimentoEstoque){
        nmProduto = produto.nmProduto();
        barra = produto.barra();
        status = produto.status();
        dataCadastro = produto.dataCadastro();
        dataCancelamento = produto.dataCancelamento();
        marca = produto.marca();
        cor = produto.cor();
        tecido = produto.tecido();
        tamanho = produto.tamanho();
    }

    public Produto(CadastroProduto produto){
        nmProduto = produto.nmProduto();
        barra = produto.barra();
        status = produto.status();
        dataCadastro = produto.dataCadastro();
        dataCancelamento = produto.dataCancelamento();
        marca = produto.marca();
        cor = produto.cor();
        tecido = produto.tecido();
        tamanho = produto.tamanho();
    }

    public Produto(CadastroProduto produto, Pedido pedido){
        nmProduto = produto.nmProduto();
        barra = produto.barra();
        status = produto.status();
        dataCadastro = produto.dataCadastro();
        dataCancelamento = produto.dataCancelamento();
        marca = produto.marca();
        cor = produto.cor();
        tecido = produto.tecido();
        tamanho = produto.tamanho();
        this.pedido = pedido;
    }

    public void atualizarDados(CadastroProduto atualizacao){
        if(atualizacao.nmProduto() != null)
            nmProduto = atualizacao.nmProduto();
        if(atualizacao.barra() != null)
            barra = atualizacao.barra();
        if(atualizacao.status() != null)
            status = atualizacao.status();
        if(atualizacao.dataCadastro() != null)
            dataCadastro = atualizacao.dataCadastro();
        if(atualizacao.dataCancelamento() != null)
            dataCancelamento = atualizacao.dataCancelamento();
        if(atualizacao.marca() != null)
            marca = atualizacao.marca();
        if(atualizacao.cor() != null)
            cor = atualizacao.cor();
        if(atualizacao.tecido() != null)
            tecido = atualizacao.tecido();
        if(atualizacao.tamanho() != null)
            tamanho = atualizacao.tamanho();
    }
}
