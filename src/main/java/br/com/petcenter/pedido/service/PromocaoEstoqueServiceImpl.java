package br.com.petcenter.pedido.service;

import br.com.petcenter.pedido.infraestructure.ProdutoRepository;
import br.com.petcenter.pedido.model.Produto;
import br.com.petcenter.pedido.model.dto.DescontoProdutoDTO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class PromocaoEstoqueServiceImpl implements PromocaoEstoqueService {

    private final ProdutoRepository produtoRepository;

    public PromocaoEstoqueServiceImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public List<DescontoProdutoDTO> listProdutosPromocao() {
        List<Produto> findAll = produtoRepository.findAll();
        List<DescontoProdutoDTO> produtosPromocao = new ArrayList<>();

        for (Produto produto : findAll) {
            if (produto.getQuantidade() > 500) {
                DescontoProdutoDTO dto = DescontoProdutoDTO.getDTO().apply(produto);
                dto.setPrecoComDesconto(produto.getPreco().subtract(produto.getPreco().multiply(new BigDecimal("0.2"))));
                dto.setPrecoOriginal(produto.getPreco());

                produtosPromocao.add(dto);
            }
        }

        return produtosPromocao;
    }
}
