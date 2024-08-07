package br.com.petcenter.pedido.model.dto;

import br.com.petcenter.pedido.model.Produto;
import lombok.Data;

import java.math.BigDecimal;
import java.util.function.Function;

@Data
public class DescontoProdutoDTO {

    private Long ean;
    private String nome;
    private Long quantidade;
    private BigDecimal precoOriginal;
    private BigDecimal precoComDesconto;

    public static toDTO getDTO() {
        return new toDTO();
    }

    public static class toDTO implements Function<Produto, DescontoProdutoDTO>{
        @Override
        public DescontoProdutoDTO apply(Produto produto) {
            DescontoProdutoDTO dto = new DescontoProdutoDTO();

            dto.setEan(produto.getEan());
            dto.setNome(produto.getNome());
            dto.setQuantidade(produto.getQuantidade());
            dto.setPrecoComDesconto(produto.getPreco());

            return dto;
        }
    }

}
