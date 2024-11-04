package br.com.NTJ.tech.repository.pedido;

import br.com.NTJ.tech.model.pedido.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
