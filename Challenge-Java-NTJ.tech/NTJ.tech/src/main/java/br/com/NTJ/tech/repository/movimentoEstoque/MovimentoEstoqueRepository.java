package br.com.NTJ.tech.repository.movimentoEstoque;

import br.com.NTJ.tech.model.movimentoEstoque.MovimentoEstoque;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimentoEstoqueRepository extends JpaRepository<MovimentoEstoque, Long> {
}
