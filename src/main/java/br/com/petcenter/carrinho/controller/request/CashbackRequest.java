package br.com.petcenter.carrinho.controller.request;

import br.com.petcenter.carrinho.model.Cliente;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CashbackRequest {
    private Cliente cliente;
    private BigDecimal valorTotal;
    private long idPedido;
}
