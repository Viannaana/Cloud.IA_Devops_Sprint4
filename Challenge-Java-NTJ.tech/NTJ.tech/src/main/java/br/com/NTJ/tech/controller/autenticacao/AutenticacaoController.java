package br.com.NTJ.tech.controller.autenticacao;

import br.com.NTJ.tech.dto.autenticacao.DadosLogin;
import br.com.NTJ.tech.dto.autenticacao.TokenJWT;
import br.com.NTJ.tech.model.usuario.Usuario;
import br.com.NTJ.tech.service.TokenService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@Tag(name = "Autenticação", description = "Operações relacionadas ao Claud.IA")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;
    @Autowired
    private TokenService tokenService;
    @PostMapping
    public ResponseEntity<TokenJWT> post(@RequestBody @Valid DadosLogin dadosLogin){
        var autenticacaoToken = new UsernamePasswordAuthenticationToken(dadosLogin.login(), dadosLogin.senha());
        var authenticate = manager.authenticate(autenticacaoToken);
        var token = tokenService.gerarToken((Usuario) authenticate.getPrincipal());
        return ResponseEntity.ok(new TokenJWT(token));
    }

}
