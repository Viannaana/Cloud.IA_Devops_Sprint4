package br.com.NTJ.tech.repository.estoque;

import br.com.NTJ.tech.model.estoque.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstoqueRepository extends JpaRepository<Estoque, Long> {
}
