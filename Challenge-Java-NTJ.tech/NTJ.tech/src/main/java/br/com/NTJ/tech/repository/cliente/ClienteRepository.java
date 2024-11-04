package br.com.NTJ.tech.repository.cliente;

import br.com.NTJ.tech.model.cliente.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
