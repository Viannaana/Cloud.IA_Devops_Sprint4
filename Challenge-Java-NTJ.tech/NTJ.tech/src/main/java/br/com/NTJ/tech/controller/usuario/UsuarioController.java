package br.com.NTJ.tech.controller.usuario;

import br.com.NTJ.tech.dto.usuario.CadastroUsuario;
import br.com.NTJ.tech.dto.usuario.DetalhesUsuario;
import br.com.NTJ.tech.model.usuario.Usuario;
import br.com.NTJ.tech.repository.usuario.UsuarioRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("usuarios")
@Tag(name = "Usuário", description = "Operações relacionadas ao Claud.IA")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @PostMapping("registrar")
    @Transactional
    @Operation(summary = "Cadastrar o usuário", description = "cadastra um usuário")
    public ResponseEntity<DetalhesUsuario> post(@RequestBody @Valid CadastroUsuario dto,
                                                UriComponentsBuilder builder){
        var usuario = new Usuario(dto.username(), passwordEncoder.encode(dto.password()));
        usuarioRepository.save(usuario);
        var url = builder.path("usuario/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(url).body(new DetalhesUsuario(usuario));
    }

}
