package br.com.NTJ.tech.dto.fornecedor;

import br.com.NTJ.tech.model.fornecedor.Fornecedor;

public record DetalhesFornecedor(Long id, String nome,
                                 String telefone, String email) {

    public DetalhesFornecedor(Fornecedor fornecedor){
        this(fornecedor.getCodigo(), fornecedor.getNome(), fornecedor.getTelefone(),
        fornecedor.getEmail());
    }
}
