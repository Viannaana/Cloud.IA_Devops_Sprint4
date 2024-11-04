package br.com.NTJ.tech.repository.fornecedor;

import br.com.NTJ.tech.model.fornecedor.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {
}
