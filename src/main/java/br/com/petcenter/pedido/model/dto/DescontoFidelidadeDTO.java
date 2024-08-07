package br.com.petcenter.pedido.model.dto;

import br.com.petcenter.pedido.model.DescontoFidelidade;
import lombok.Data;

import java.math.BigDecimal;
import java.util.function.Function;

@Data
public class DescontoFidelidadeDTO {

    private Long id;
    private Long idPedido;
    private BigDecimal desconto;

    public static toDTO getDTO() {
        return new toDTO();
    }

    public static class toDTO implements Function<DescontoFidelidade, DescontoFidelidadeDTO> {
        @Override
        public DescontoFidelidadeDTO apply(DescontoFidelidade descontoFidelidade) {
            DescontoFidelidadeDTO dto = new DescontoFidelidadeDTO();

            dto.setDesconto(descontoFidelidade.getDesconto());
            dto.setId(descontoFidelidade.getId());
            dto.setIdPedido(descontoFidelidade.getIdPedido());

            return dto;
        }
    }

}
