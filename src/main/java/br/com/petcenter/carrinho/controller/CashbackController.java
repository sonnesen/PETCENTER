package br.com.petcenter.carrinho.controller;

import br.com.petcenter.carrinho.controller.request.CashbackRequest;
import br.com.petcenter.carrinho.model.dto.CashbackDTO;
import br.com.petcenter.carrinho.service.CashbackService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CashbackController {

    private final CashbackService service;

    public CashbackController(CashbackService service) {
        this.service = service;
    }

    @PostMapping(value = "/cashback", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CashbackDTO> aplicarCashback(@RequestBody CashbackRequest request) {
        CashbackDTO cashback = service.calcularCashback(request.getIdPedido(), request.getCliente().getFidelidade(), request.getValorTotal());

        return ResponseEntity.ok().body(cashback);
    }
}
