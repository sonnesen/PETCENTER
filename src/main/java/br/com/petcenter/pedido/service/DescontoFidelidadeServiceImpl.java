package br.com.petcenter.pedido.service;

import br.com.petcenter.pedido.infraestructure.DescontoFIdelidadeRepository;
import br.com.petcenter.pedido.model.DescontoFidelidade;
import br.com.petcenter.pedido.model.dto.DescontoFidelidadeDTO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class DescontoFidelidadeServiceImpl implements DescontoFidelidadeService {

    private static final BigDecimal DESCONTO_BRONZE = BigDecimal.ZERO;
    private static final BigDecimal DESCONTO_PRATA = new BigDecimal("0.02");
    private static final BigDecimal DESCONTO_OURO = new BigDecimal("0.05");

    private final DescontoFIdelidadeRepository repository;

    public DescontoFidelidadeServiceImpl(DescontoFIdelidadeRepository repository) {
        this.repository = repository;
    }

    @Override
    public DescontoFidelidadeDTO calcularDescontoFidelidade(Long idPedido, int nivelFidelidade, BigDecimal valorCompra) {
        BigDecimal valorDesconto = switch (nivelFidelidade) {
            case 1 -> DESCONTO_BRONZE;
            case 2 -> valorCompra.multiply(DESCONTO_PRATA);
            case 3 -> valorCompra.multiply(DESCONTO_OURO);
            default -> throw new IllegalStateException("Unexpected value: " + nivelFidelidade);
        };

        DescontoFidelidade descontoFidelidade = new DescontoFidelidade();

        descontoFidelidade.setIdPedido(idPedido);
        descontoFidelidade.setDesconto(valorDesconto);

        descontoFidelidade = repository.save(descontoFidelidade);

        return DescontoFidelidadeDTO.getDTO().apply(descontoFidelidade);
    }
}
