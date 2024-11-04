package br.com.NTJ.tech.repository.categoria;

import br.com.NTJ.tech.model.categoria.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
