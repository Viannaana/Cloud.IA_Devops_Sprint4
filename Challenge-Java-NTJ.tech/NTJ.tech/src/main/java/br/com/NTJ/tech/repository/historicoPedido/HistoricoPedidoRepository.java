package br.com.NTJ.tech.repository.historicoPedido;

import br.com.NTJ.tech.model.historicoPedido.HistoricoPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoricoPedidoRepository extends JpaRepository<HistoricoPedido, Long> {
}
