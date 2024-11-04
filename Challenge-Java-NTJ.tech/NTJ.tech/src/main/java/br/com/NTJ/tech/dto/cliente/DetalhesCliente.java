package br.com.NTJ.tech.dto.cliente;

import br.com.NTJ.tech.model.cliente.Cliente;

import java.time.LocalDate;

public record DetalhesCliente(Long id, String nome, String email, String telefone,
                              LocalDate Cadastro, LocalDate Cancelamento, String status) {

    public DetalhesCliente(Cliente cliente){
        this(cliente.getCodigo(), cliente.getNome(), cliente.getEmail(), cliente.getTelefone(),
                cliente.getDataCadastro(), cliente.getDataCancelamento(), cliente.getStatusAtivo());
    }
}
