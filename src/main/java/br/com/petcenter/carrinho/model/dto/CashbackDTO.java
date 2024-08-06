package br.com.petcenter.carrinho.model.dto;

import br.com.petcenter.carrinho.model.Cashback;
import lombok.Data;

import java.math.BigDecimal;
import java.util.function.Function;

@Data
public class CashbackDTO {
    private Long id;
    private Long idPedido;
    private BigDecimal cashback;

    public static toDTO getDTO() {
        return new toDTO();
    }

    public static class toDTO implements Function<Cashback, CashbackDTO> {
        @Override
        public CashbackDTO apply(Cashback cashback) {
            CashbackDTO dto = new CashbackDTO();

            dto.setCashback(cashback.getCashback());
            dto.setId(cashback.getId());
            dto.setIdPedido(cashback.getIdPedido());

            return dto;
        }
    }
}
