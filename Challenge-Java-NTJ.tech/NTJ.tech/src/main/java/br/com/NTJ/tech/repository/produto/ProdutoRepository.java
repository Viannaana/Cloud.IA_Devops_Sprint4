package br.com.NTJ.tech.repository.produto;

import br.com.NTJ.tech.model.produto.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
