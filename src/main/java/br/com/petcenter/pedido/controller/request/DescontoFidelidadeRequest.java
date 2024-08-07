package br.com.petcenter.pedido.controller.request;

import br.com.petcenter.pedido.model.Cliente;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class DescontoFidelidadeRequest {

    private Cliente cliente;
    private BigDecimal valorTotal;
    private Long idPedido;
}
