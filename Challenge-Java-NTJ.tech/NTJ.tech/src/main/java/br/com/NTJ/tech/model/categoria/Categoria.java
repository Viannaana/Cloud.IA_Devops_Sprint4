package br.com.NTJ.tech.model.categoria;

import br.com.NTJ.tech.dto.categoria.CadastroCategoria;
import br.com.NTJ.tech.dto.produto.CadastroProduto;
import br.com.NTJ.tech.model.produto.Produto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "TB_CATEGORIA")
@EntityListeners(AuditingEntityListener.class)
public class Categoria {

    @Id
    @GeneratedValue
    @Column(name = "ID_CATEGORIA_TIPO")
    private Long codigo;

    //não obrigatório
    @Column(name = "NM_CATEGORIA", length = 100, nullable = true)
    private String nome;

    @Column(name = "DC_CATEGORIA", length = 200, nullable = false)
    private String descricao;


    public Categoria(CadastroCategoria atualizacao){
        if (atualizacao.nome() !=null);
        nome = atualizacao.nome();
        descricao = atualizacao.descricao();
    }

    public void atualizarDados(CadastroCategoria atualizacao){
        if(atualizacao.nome() != null)
            nome = atualizacao.nome();
        if(atualizacao.descricao() != null)
            descricao = atualizacao.descricao();
    }
}
