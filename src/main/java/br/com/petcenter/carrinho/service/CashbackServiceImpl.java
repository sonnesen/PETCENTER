package br.com.petcenter.carrinho.service;

import br.com.petcenter.carrinho.infraestructure.CashbackRepository;
import br.com.petcenter.carrinho.model.Cashback;
import br.com.petcenter.carrinho.model.dto.CashbackDTO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CashbackServiceImpl implements CashbackService {

    private static final BigDecimal CASHBACK_BRONZE = BigDecimal.ZERO;
    private static final BigDecimal CASHBACK_PRATA = new BigDecimal("0.02");
    private static final BigDecimal CASHBACK_OURO = new BigDecimal("0.05");
    private final CashbackRepository repository;

    public CashbackServiceImpl(CashbackRepository repository) {
        this.repository = repository;
    }

    @Override
    public CashbackDTO calcularCashback(long idPedido, int nivelFidelidade, BigDecimal valorCompra) {
        BigDecimal valorCashback = switch (nivelFidelidade) {
            case 1 -> CASHBACK_BRONZE;
            case 2 -> valorCompra.multiply(CASHBACK_PRATA);
            case 3 -> valorCompra.multiply(CASHBACK_OURO);
            default -> throw new IllegalStateException("Unexpected value: " + nivelFidelidade);
        };
        Cashback cashback = new Cashback();

        cashback.setIdPedido(idPedido);
        cashback.setCashback(valorCashback);

        cashback = repository.save(cashback);

        return CashbackDTO.getDTO().apply(cashback);
    }
}
