package br.com.petcenter.pedido.infraestructure;

import br.com.petcenter.pedido.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
