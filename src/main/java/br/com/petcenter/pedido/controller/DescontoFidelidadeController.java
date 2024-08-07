package br.com.petcenter.pedido.controller;

import br.com.petcenter.pedido.controller.request.DescontoFidelidadeRequest;
import br.com.petcenter.pedido.model.dto.DescontoFidelidadeDTO;
import br.com.petcenter.pedido.service.DescontoFidelidadeService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DescontoFidelidadeController {

    private final DescontoFidelidadeService service;

    public DescontoFidelidadeController(DescontoFidelidadeService service) {
        this.service = service;
    }

    @PostMapping(value = "/desconto-fidelidade", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DescontoFidelidadeDTO> aplicarDesconto(@RequestBody DescontoFidelidadeRequest request) {
        DescontoFidelidadeDTO desconto = service.calcularDescontoFidelidade(request.getIdPedido(), request.getCliente().getFidelidade(), request.getValorTotal());

        return ResponseEntity.ok().body(desconto);
    }

}
