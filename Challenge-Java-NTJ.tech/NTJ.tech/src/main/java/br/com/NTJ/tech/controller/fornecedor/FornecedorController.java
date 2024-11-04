package br.com.NTJ.tech.controller.fornecedor;

import br.com.NTJ.tech.dto.categoria.DetalhesCategoria;
import br.com.NTJ.tech.dto.fornecedor.CadastroFornecedor;
import br.com.NTJ.tech.dto.fornecedor.DetalhesFornecedor;
import br.com.NTJ.tech.model.fornecedor.Fornecedor;
import br.com.NTJ.tech.repository.fornecedor.FornecedorRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
@RestController
@RequestMapping("fornecedores")
@Tag(name = "Fornecedor", description = "Operações relacionadas ao Claud.IA")
public class FornecedorController {

    @Autowired
    private FornecedorRepository repository;

    @GetMapping
    public ResponseEntity<List<DetalhesFornecedor>> listar(Pageable pageable){
        var lista = repository.findAll(pageable)
                .stream().map(DetalhesFornecedor::new).toList();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("{id}")
    @Operation(summary = "Pesquisar o fornecedor por ID", description = "pesquisa um fornecedor")
    @Parameters({
            @Parameter(name="id", description = "Pesquisa fornecedor por id", required = true)
    })
    public ResponseEntity<DetalhesFornecedor> buscar(@PathVariable("id") Long id){
        var fornecedor = repository.getReferenceById(id);
        return ResponseEntity.ok(new DetalhesFornecedor(fornecedor));
    }

    @PostMapping
    @Transactional
    @Operation(summary = "Cadastrar o fornecedor", description = "cadastra um fornecedor")
    @ApiResponses({@ApiResponse(responseCode = "201", description = "Cadastro com Sucesso", content =
    @Content(schema = @Schema(implementation = DetalhesCategoria.class), mediaType = "application/json")),
            @ApiResponse(responseCode = "403", description = "Não Autorizado ou Token Inválido", content =
                    { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")})
    public ResponseEntity<DetalhesFornecedor> cadastrar(@RequestBody CadastroFornecedor fornecedorPost,
                                                     UriComponentsBuilder uri){
        var fornecedor = new Fornecedor(fornecedorPost);
        repository.save(fornecedor);
        var url = uri.path("/fornecedores/{id}").buildAndExpand(fornecedor.getCodigo()).toUri();
        return ResponseEntity.created(url).body(new DetalhesFornecedor(fornecedor));
    }

    @PutMapping("{id}")
    @Transactional
    @Operation(summary = "Alterar o fornecedor por ID", description = "altera um fornecedor")
    public ResponseEntity<DetalhesFornecedor> atualizar(@PathVariable("id") Long id,
                                                     @RequestBody CadastroFornecedor fornecedorPut){
        var fornecedor = repository.getReferenceById(id);
        fornecedor.atualizarDados(fornecedorPut);
        return ResponseEntity.ok(new DetalhesFornecedor(fornecedor));
    }

    @DeleteMapping("{id}")
    @Transactional
    @Operation(summary = "Deletar o fornecedor por ID", description = "deleta um produto")
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
