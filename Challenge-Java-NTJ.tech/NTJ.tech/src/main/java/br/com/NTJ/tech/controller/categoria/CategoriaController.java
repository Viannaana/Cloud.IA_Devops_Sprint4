package br.com.NTJ.tech.controller.categoria;

import br.com.NTJ.tech.dto.categoria.CadastroCategoria;
import br.com.NTJ.tech.dto.categoria.DetalhesCategoria;
import br.com.NTJ.tech.model.categoria.Categoria;
import br.com.NTJ.tech.repository.categoria.CategoriaRepository;
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
@RequestMapping("categorias")
@Tag(name = "Categoria", description = "Operações relacionadas ao Claud.IA")
public class CategoriaController {

    @Autowired
    private CategoriaRepository repository;

    @GetMapping
    public ResponseEntity<List<DetalhesCategoria>> listar(Pageable pageable){
        var lista = repository.findAll(pageable)
                .stream().map(DetalhesCategoria::new).toList();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("{id}")
    @Operation(summary = "Pesquisar a categoria por ID", description = "pesquisa uma categoria")
    @Parameters({
            @Parameter(name="id", description = "Pesquisa categoria por id", required = true)
    })
    public ResponseEntity<DetalhesCategoria> buscar(@PathVariable("id") Long id){
        var categoria = repository.getReferenceById(id);
        return ResponseEntity.ok(new DetalhesCategoria(categoria));
    }

    @PostMapping
    @Transactional
    @Operation(summary = "Cadastrar a categoria", description = "cadastra uma categoria")
    @ApiResponses({@ApiResponse(responseCode = "201", description = "Cadastro com Sucesso", content =
    @Content(schema = @Schema(implementation = DetalhesCategoria.class), mediaType = "application/json")),
            @ApiResponse(responseCode = "403", description = "Não Autorizado ou Token Inválido", content =
                    { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")})
    public ResponseEntity<DetalhesCategoria> cadastrar(@RequestBody CadastroCategoria categoriaPost,
                                                     UriComponentsBuilder uri){
        var categoria = new Categoria(categoriaPost);
        repository.save(categoria);
        var url = uri.path("/clientes/{id}").buildAndExpand(categoria.getCodigo()).toUri();
        return ResponseEntity.created(url).body(new DetalhesCategoria(categoria));
    }

    @PutMapping("{id}")
    @Transactional
    @Operation(summary = "Alterar a categoria por ID", description = "altera uma categoria")
    public ResponseEntity<DetalhesCategoria> atualizar(@PathVariable("id") Long id,
                                                     @RequestBody CadastroCategoria categoriaPut){
        var categoria = repository.getReferenceById(id);
        categoria.atualizarDados(categoriaPut);
        return ResponseEntity.ok(new DetalhesCategoria(categoria));
    }

    @DeleteMapping("{id}")
    @Transactional
    @Operation(summary = "Deletar a categoria por ID", description = "deleta uma categoria")
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
