package br.com.NTJ.tech.controller.cliente;

import br.com.NTJ.tech.dto.categoria.DetalhesCategoria;
import br.com.NTJ.tech.dto.cliente.CadastroCliente;
import br.com.NTJ.tech.dto.cliente.DetalhesCliente;
import br.com.NTJ.tech.dto.pedido.CadastroPedido;
import br.com.NTJ.tech.dto.pedido.DetalhesClientePedido;
import br.com.NTJ.tech.model.cliente.Cliente;
import br.com.NTJ.tech.model.pedido.Pedido;
import br.com.NTJ.tech.repository.cliente.ClienteRepository;
import br.com.NTJ.tech.repository.pedido.PedidoRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("clientes")
@Tag(name = "Cliente", description = "Operações relacionadas ao Claud.IA")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping
    public ResponseEntity<List<DetalhesCliente>> listar(Pageable pageable){
        var lista = repository.findAll(pageable)
                .stream().map(DetalhesCliente::new).toList();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("{id}")
    @Operation(summary = "Pesquisar o cliente por ID", description = "pesquisa um cliente")
    @Parameters({
            @Parameter(name="id", description = "Pesquisa cliente por id", required = true)
    })
    public ResponseEntity<DetalhesCliente> buscar(@PathVariable("id") Long id){
        var cliente = repository.getReferenceById(id);
        return ResponseEntity.ok(new DetalhesCliente(cliente));
    }

    @PostMapping
    @Transactional
    @Operation(summary = "Cadastrar o cliente", description = "cadastra um cliente")
    @ApiResponses({@ApiResponse(responseCode = "201", description = "Cadastro com Sucesso", content =
    @Content(schema = @Schema(implementation = DetalhesCategoria.class), mediaType = "application/json")),
            @ApiResponse(responseCode = "403", description = "Não Autorizado ou Token Inválido", content =
                    { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")})
    public ResponseEntity<DetalhesCliente> cadastrar(@RequestBody CadastroCliente clientePost,
                                                     UriComponentsBuilder uri){
        var cliente = new Cliente(clientePost);
        repository.save(cliente);
        var url = uri.path("/clientes/{id}").buildAndExpand(cliente.getCodigo()).toUri();
        return ResponseEntity.created(url).body(new DetalhesCliente(cliente));
    }

    //Tabela da cliente para pedido
    @PostMapping("{id}/clientePedido")
    @Transactional
    @Operation(summary = "Cadastrar o pedido em cliente", description = "cadastra um pedido em cliente")
    public ResponseEntity<DetalhesClientePedido> postClientePedido(@PathVariable("id")Long id,
                                                                   @RequestBody @Valid CadastroPedido dto,
                                                                   UriComponentsBuilder uriBuilder){
        var cliente = repository.getReferenceById(id);
        var pedido = new Pedido(dto, cliente);
        pedidoRepository.save(pedido);
        var uri = uriBuilder.path("clientePedido/{id}").buildAndExpand(pedido.getCodigo()).toUri();
        return ResponseEntity.created(uri).body(new DetalhesClientePedido(pedido));
    }
    @PutMapping("{id}")
    @Transactional
    @Operation(summary = "Alterar o cliente por ID", description = "altera um cliente")
    public ResponseEntity<DetalhesCliente> atualizar(@PathVariable("id") Long id,
                                                     @RequestBody CadastroCliente clientePut){
        var cliente = repository.getReferenceById(id);
        cliente.atualizarDados(clientePut);
        return ResponseEntity.ok(new DetalhesCliente(cliente));
    }

    @DeleteMapping("{id}")
    @Transactional
    @Operation(summary = "Deletar o cliente por ID", description = "deleta um cliente")
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
