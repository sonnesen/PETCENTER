package br.com.petcenter.carrinho.infraestructure;

import br.com.petcenter.carrinho.model.Cashback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CashbackRepository extends JpaRepository<Cashback, Long> {
}
