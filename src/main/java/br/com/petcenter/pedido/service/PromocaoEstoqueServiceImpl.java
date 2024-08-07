package br.com.petcenter.pedido.service;

import br.com.petcenter.pedido.infraestructure.ProdutoRepository;
import br.com.petcenter.pedido.model.Produto;
import br.com.petcenter.pedido.model.dto.ProdutoDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PromocaoEstoqueServiceImpl implements PromocaoEstoqueService {

    private final ProdutoRepository produtoRepository;

    public PromocaoEstoqueServiceImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public List<ProdutoDTO> listProdutosPromocao() {
        List<Produto> findAll = produtoRepository.findAll();
        List<ProdutoDTO> produtosPromocao = new ArrayList<>();

        for (Produto produto : findAll) {
            if (produto.getQuantidade() > 500) {
                produtosPromocao.add(ProdutoDTO.getDTO().apply(produto));
            }
        }

        return produtosPromocao;
    }
}
