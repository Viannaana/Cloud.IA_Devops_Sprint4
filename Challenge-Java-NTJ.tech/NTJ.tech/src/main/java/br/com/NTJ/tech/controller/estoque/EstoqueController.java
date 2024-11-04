package br.com.NTJ.tech.controller.estoque;

import br.com.NTJ.tech.dto.categoria.DetalhesCategoria;
import br.com.NTJ.tech.dto.estoque.CadastroEstoque;
import br.com.NTJ.tech.dto.estoque.DetalhesEstoque;
import br.com.NTJ.tech.model.estoque.Estoque;
import br.com.NTJ.tech.repository.estoque.EstoqueRepository;
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
@RequestMapping("estoques")
@Tag(name = "Estoque", description = "Operações relacionadas ao Claud.IA")
public class EstoqueController {

    @Autowired
    private EstoqueRepository repository;

    @GetMapping
    public ResponseEntity<List<DetalhesEstoque>> listar(Pageable pageable){
        var lista = repository.findAll(pageable)
                .stream().map(DetalhesEstoque::new).toList();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("{id}")
    @Operation(summary = "Pesquisar o estoque por ID", description = "pesquisa um estoque")
    @Parameters({
            @Parameter(name="id", description = "Pesquisa estoque por id", required = true)
    })
    public ResponseEntity<DetalhesEstoque> buscar(@PathVariable("id") Long id){
        var estoque = repository.getReferenceById(id);
        return ResponseEntity.ok(new DetalhesEstoque(estoque));
    }

    @PostMapping
    @Transactional
    @Operation(summary = "Cadastar o estoque", description = "cadastra um estoque")
    @ApiResponses({@ApiResponse(responseCode = "201", description = "Cadastro com Sucesso", content =
    @Content(schema = @Schema(implementation = DetalhesCategoria.class), mediaType = "application/json")),
            @ApiResponse(responseCode = "403", description = "Não Autorizado ou Token Inválido", content =
                    { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")})
    public ResponseEntity<DetalhesEstoque> cadastrar(@RequestBody CadastroEstoque estoquePost,
                                                     UriComponentsBuilder uri){
        var estoque = new Estoque(estoquePost);
        repository.save(estoque);
        var url = uri.path("/estoques/{id}").buildAndExpand(estoque.getCodigo()).toUri();
        return ResponseEntity.created(url).body(new DetalhesEstoque(estoque));
    }

    @PutMapping("{id}")
    @Transactional
    @Operation(summary = "Alterar o estoque por ID", description = "altera um estoque")
    public ResponseEntity<DetalhesEstoque> atualizar(@PathVariable("id") Long id,
                                                     @RequestBody CadastroEstoque estoquePut){
        var estoque = repository.getReferenceById(id);
        estoque.atualizarDados(estoquePut);
        return ResponseEntity.ok(new DetalhesEstoque(estoque));
    }

    @DeleteMapping("{id}")
    @Transactional
    @Operation(summary = "Deletar o estoque por ID", description = "deleta um estoque")
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
