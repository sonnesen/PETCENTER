package br.com.petcenter.pedido.service;

import br.com.petcenter.pedido.model.dto.DescontoFidelidadeDTO;

import java.math.BigDecimal;

public interface DescontoFidelidadeService {

    DescontoFidelidadeDTO calcularDescontoFidelidade(Long idPedido, int nivelFidelidade, BigDecimal valorCompra);
}
