package br.com.petcenter.cupom.infraestructure;

import br.com.petcenter.cupom.model.Cupom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CupomRepository extends JpaRepository<Cupom, String>{
}
