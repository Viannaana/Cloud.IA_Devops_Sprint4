package br.com.NTJ.tech.model.fornecedor;

import br.com.NTJ.tech.dto.fornecedor.CadastroFornecedor;
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
@Table(name = "TB_FORNECEDOR")
@EntityListeners(AuditingEntityListener.class)
public class Fornecedor {

    @Id
    @GeneratedValue
    @Column(name = "ID_FORNECEDOR")
    private Long codigo;

    @Column(name = "NM_FORNECEDOR", length = 100, nullable = false)
    private String nome;

    @Column(name = "DS_TELEFONE", length = 15, nullable = false)
    private String telefone;

    @Column(name = "DS_EMAIL", length = 100, nullable = false)
    private String email;

    public Fornecedor(CadastroFornecedor fornecedor){
        nome = fornecedor.nome();
        telefone = fornecedor.telefone();
        email = fornecedor.email();
    }

    public void atualizarDados(CadastroFornecedor atualizacao){
        if(atualizacao.nome() != null)
            nome = atualizacao.nome();
        if(atualizacao.telefone() != null)
            telefone = atualizacao.telefone();
        if(atualizacao.email() != null)
            email = atualizacao.email();

    }

}
