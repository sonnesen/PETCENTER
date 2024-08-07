package br.com.petcenter.pedido.infraestructure;

import br.com.petcenter.pedido.model.DescontoFidelidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DescontoFIdelidadeRepository extends JpaRepository<DescontoFidelidade, Long> {
}
