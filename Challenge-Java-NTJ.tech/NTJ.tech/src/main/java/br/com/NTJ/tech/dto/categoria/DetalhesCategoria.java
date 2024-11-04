package br.com.NTJ.tech.dto.categoria;

import br.com.NTJ.tech.model.categoria.Categoria;

public record DetalhesCategoria(Long id, String nome, String descricao) {

    public DetalhesCategoria(Categoria categoria){
        this(categoria.getCodigo(), categoria.getNome(), categoria.getDescricao());
    }
}
