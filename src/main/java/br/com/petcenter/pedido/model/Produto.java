package br.com.petcenter.pedido.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
public class Produto {

    @Id
    private Long ean;
    private String nome;
    private Long quantidade;
    private BigDecimal preco;

}
