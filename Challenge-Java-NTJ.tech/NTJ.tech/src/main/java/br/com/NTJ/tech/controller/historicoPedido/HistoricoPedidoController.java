package br.com.NTJ.tech.controller.historicoPedido;

import br.com.NTJ.tech.dto.categoria.DetalhesCategoria;
import br.com.NTJ.tech.dto.historicoPedido.CadastroHistoricoPedido;
import br.com.NTJ.tech.dto.historicoPedido.DetalhesHistoricoPedido;
import br.com.NTJ.tech.model.historicoPedido.HistoricoPedido;
import br.com.NTJ.tech.repository.historicoPedido.HistoricoPedidoRepository;
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
@RequestMapping("historicos")
@Tag(name = "Historico Pedido", description = "Operações relacionadas ao Claud.IA")
public class HistoricoPedidoController {

    @Autowired
    private HistoricoPedidoRepository repository;

    @GetMapping
    public ResponseEntity<List<DetalhesHistoricoPedido>> listar(Pageable pageable){
        var lista = repository.findAll(pageable)
                .stream().map(DetalhesHistoricoPedido::new).toList();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("{id}")
    @Operation(summary = "Pesquisar o histórico de pedido por ID", description = "pesquisa um phistórico de pedido")
    @Parameters({
            @Parameter(name="id", description = "Pesquisa historico de pedido por id", required = true)
    })
    public ResponseEntity<DetalhesHistoricoPedido> buscar(@PathVariable("id") Long id){
        var historicoPedido = repository.getReferenceById(id);
        return ResponseEntity.ok(new DetalhesHistoricoPedido(historicoPedido));
    }

    @PostMapping
    @Transactional
    @Operation(summary = "Cadastro historico de pedido por ID", description = "cadastra um historico de pedido")
    @ApiResponses({@ApiResponse(responseCode = "201", description = "Cadastro com Sucesso", content =
    @Content(schema = @Schema(implementation = DetalhesCategoria.class), mediaType = "application/json")),
            @ApiResponse(responseCode = "403", description = "Não Autorizado ou Token Inválido", content =
                    { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")})
    public ResponseEntity<DetalhesHistoricoPedido> cadastrar(@RequestBody CadastroHistoricoPedido historicoPost,
                                                     UriComponentsBuilder uri){
        var historicoPedido = new HistoricoPedido(historicoPost);
        repository.save(historicoPedido);
        var url = uri.path("/historicos/{id}").buildAndExpand(historicoPedido.getCodigo()).toUri();
        return ResponseEntity.created(url).body(new DetalhesHistoricoPedido(historicoPedido));
    }

    @PutMapping("{id}")
    @Transactional
    @Operation(summary = "Alterar o historico de pedido por ID", description = "altera um pedido")
    public ResponseEntity<DetalhesHistoricoPedido> atualizar(@PathVariable("id") Long id,
                                                     @RequestBody CadastroHistoricoPedido historicoPut){
        var historicoPedido = repository.getReferenceById(id);
        historicoPedido.atualizarDados(historicoPut);
        return ResponseEntity.ok(new DetalhesHistoricoPedido(historicoPedido));
    }

    @DeleteMapping("{id}")
    @Transactional
    @Operation(summary = "Deletar o historico de pedido por ID", description = "deletar im historico de pedido")
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
