package br.com.NTJ.tech.controller.movimentoEstoque;

import br.com.NTJ.tech.dto.MovimentoEstoque.CadastroMovimentoEstoque;
import br.com.NTJ.tech.dto.MovimentoEstoque.DetalhesMovimentoEstoque;
import br.com.NTJ.tech.dto.categoria.DetalhesCategoria;
import br.com.NTJ.tech.model.movimentoEstoque.MovimentoEstoque;
import br.com.NTJ.tech.repository.movimentoEstoque.MovimentoEstoqueRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
@RestController
@RequestMapping("movimentos")
@Tag(name = "Movimento Estoque", description = "Operações relacionadas ao Claud.IA")
public class MovimentoEstoqueController {

    @Autowired
    private MovimentoEstoqueRepository repository;

    @GetMapping
    public ResponseEntity<List<DetalhesMovimentoEstoque>> listar(Pageable pageable){
        var lista = repository.findAll(pageable)
                .stream().map(DetalhesMovimentoEstoque::new).toList();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("{id}")
    @Operation(summary = "Pesquisar o movimento de estoque por ID", description = "pesquisa um movimento de estoque")
    @Parameters({
            @Parameter(name="id", description = "Pesquisa movimento de estoque por id", required = true)
    })
    public ResponseEntity<DetalhesMovimentoEstoque> buscar(@PathVariable("id") Long id){
        var movimentoEstoque = repository.getReferenceById(id);
        return ResponseEntity.ok(new DetalhesMovimentoEstoque(movimentoEstoque));
    }

    @PostMapping
    @Transactional
    @Operation(summary = "Cadastrar o movimento de estoque", description = "cadastra um movimento de estoque")
    @ApiResponses({@ApiResponse(responseCode = "201", description = "Cadastro com Sucesso", content =
    @Content(schema = @Schema(implementation = DetalhesCategoria.class), mediaType = "application/json")),
            @ApiResponse(responseCode = "403", description = "Não Autorizado ou Token Inválido", content =
                    { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")})
    public ResponseEntity<DetalhesMovimentoEstoque> cadastrar(@RequestBody CadastroMovimentoEstoque movimentoPost,
                                                     UriComponentsBuilder uri){
        var movimentoEstoque = new MovimentoEstoque(movimentoPost);
        repository.save(movimentoEstoque);
        var url = uri.path("/movimentos/{id}").buildAndExpand(movimentoEstoque.getCodigo()).toUri();
        return ResponseEntity.created(url).body(new DetalhesMovimentoEstoque(movimentoEstoque));
    }

    @PutMapping("{id}")
    @Transactional
    @Operation(summary = "Alterar o movimento de estoque por ID", description = "altera um movimento de estoque")
    public ResponseEntity<DetalhesMovimentoEstoque> atualizar(@PathVariable("id") Long id,
                                                     @RequestBody CadastroMovimentoEstoque movimentoPut){
        var movimentoEstoque = repository.getReferenceById(id);
        movimentoEstoque.atualizarDados(movimentoPut);
        return ResponseEntity.ok(new DetalhesMovimentoEstoque(movimentoEstoque));
    }

    @DeleteMapping("{id}")
    @Transactional
    @Operation(summary = "Deletar o movimento de estoque por ID", description = "deleta um movimento de estoque")
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
