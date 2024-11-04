package br.com.NTJ.tech.model.cliente;

import br.com.NTJ.tech.dto.cliente.CadastroCliente;
import br.com.NTJ.tech.model.pedido.Pedido;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "TB_CLIENTE")
@EntityListeners(AuditingEntityListener.class)
public class Cliente {

    @Id
    @GeneratedValue
    @Column(name = "ID_CLIENTE")
    private Long codigo;

    @Column(name = "NM_CLIENTE", length = 100, nullable = false)
    private String nome;

    @Column(name = "DS_EMAIL", length = 100, nullable = false)
    private String email;

    @Column(name = "DS_TELEFONE", length = 15, nullable = false)
    private String telefone;

    @Column(name = "DT_CADASTRO", nullable = false)
    private LocalDate dataCadastro;

    @Column(name = "DT_CANCELAMENTO", nullable = false)
    private LocalDate dataCancelamento;

    @Column(name = "STA_ATIVO", length = 100, nullable = false)
    private String statusAtivo;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Pedido> pedidos;

    public Cliente(CadastroCliente cliente){
        nome = cliente.nome();
        email = cliente.email();
        telefone = cliente.telefone();
        dataCadastro = cliente.cadastro();
        dataCancelamento = cliente.cancelamento();
        statusAtivo = cliente.status();
    }

    public void atualizarDados(CadastroCliente atualizacao){
        if(atualizacao.nome() != null)
            nome = atualizacao.nome();
        if(atualizacao.email() != null)
            email = atualizacao.email();
        if(atualizacao.telefone() != null)
            telefone = atualizacao.telefone();
        if(atualizacao.cadastro() != null)
             dataCadastro = atualizacao.cadastro();
        if(atualizacao.cancelamento() != null)
            dataCancelamento = atualizacao.cancelamento();
    }

}
