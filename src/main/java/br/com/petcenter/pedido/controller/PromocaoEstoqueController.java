package br.com.petcenter.pedido.controller;

import br.com.petcenter.pedido.model.dto.ProdutoDTO;
import br.com.petcenter.pedido.service.PromocaoEstoqueService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PromocaoEstoqueController {

    private final PromocaoEstoqueService promocaoEstoqueService;

    public PromocaoEstoqueController(PromocaoEstoqueService promocaoEstoqueService) {
        this.promocaoEstoqueService = promocaoEstoqueService;
    }

    @GetMapping("/promocaoPorEstoque")
    public ResponseEntity<List<ProdutoDTO>> listProdutoPromocao() {
        return ResponseEntity.ok(promocaoEstoqueService.listProdutosPromocao());
    }

}
