package br.com.NTJ.tech.dto.usuario;

import br.com.NTJ.tech.model.usuario.Usuario;

public record DetalhesUsuario(Long id, String username) {

    public DetalhesUsuario(Usuario usuario){

        this(usuario.getId(), usuario.getUsername());
    }
}
