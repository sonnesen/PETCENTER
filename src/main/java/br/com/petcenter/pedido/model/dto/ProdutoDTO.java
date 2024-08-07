package br.com.petcenter.pedido.model.dto;

import br.com.petcenter.pedido.model.Produto;
import lombok.Data;

import java.util.function.Function;

@Data
public class ProdutoDTO {

    private Long ean;
    private String nome;
    private Long quantidade;

    public static toDTO getDTO() {
        return new toDTO();
    }

    public static class toDTO implements Function<Produto, ProdutoDTO>{
        @Override
        public ProdutoDTO apply(Produto produto) {
            ProdutoDTO dto = new ProdutoDTO();

            dto.setEan(produto.getEan());
            dto.setNome(produto.getNome());
            dto.setQuantidade(produto.getQuantidade());

            return dto;
        }
    }

}
