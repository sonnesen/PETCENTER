package br.com.petcenter.carrinho.service;

import br.com.petcenter.carrinho.model.dto.CashbackDTO;

import java.math.BigDecimal;

public interface CashbackService {
    CashbackDTO calcularCashback(long idPedido, int nivelFidelidade, BigDecimal valorCompra);
}
